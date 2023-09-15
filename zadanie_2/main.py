import sqlite3

conn = sqlite3.connect('my_database.db')
cursor = conn.cursor()

cursor.execute('''
    CREATE TABLE IF NOT EXISTS Students (
        StudentID INTEGER PRIMARY KEY,
        FirstName TEXT,
        LastName TEXT,
        Age INTEGER,
        Grade TEXT
    )
''')

cursor.execute('''
    INSERT INTO Students (FirstName, LastName, Age, Grade)
    VALUES (?, ?, ?, ?)
''', ('John', 'Doe', 22, 'A'))

cursor.execute('''
    INSERT INTO Students (FirstName, LastName, Age, Grade)
    VALUES (?, ?, ?, ?)
''', ('Jane', 'Smith', 19, 'B'))

conn.commit()

cursor.execute('SELECT * FROM Students')
print("All Students:")
for row in cursor.fetchall():
    print(row)

cursor.execute('DELETE FROM Students WHERE StudentID = ?', (1,))
conn.commit()

cursor.execute('SELECT * FROM Students')
print("\nStudents after deletion:")
for row in cursor.fetchall():
    print(row)

conn.close()
