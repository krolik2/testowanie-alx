import requests
from bs4 import BeautifulSoup

url = "https://wykop.pl"
response = requests.get(url)
soup = BeautifulSoup(response.content, "html.parser")
elements = soup.select("section.link-block")

list_of_articles = []

for element in elements:
    name = element.find("a").get_text(strip=True)
    link = element.find("a")["href"]
    desc = element.select_one("p > a")
    desc = desc.get_text(strip=True) if desc else "brak opisu"
    votes = element.find("div", class_="dig")
    votes = votes.get_text(strip=True).strip("Wykop") if votes else "0"

    new_article = {
        "Tytuł": name,
        "Wykopy": votes,
        "Opis": desc,
        "Link": f"{url}{link}",
    }

    list_of_articles.append(new_article)

with open("output.txt", "w") as outFile:
    for idx, d in enumerate(list_of_articles):
        line = (
            str(idx + 1)
            + ".\n"
            + "\n".join([str(key) + ": " + str(value) for key, value in d.items()])
            + "\n"
        )
        outFile.write(line)
