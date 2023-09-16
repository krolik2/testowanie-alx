import requests
import json


def get_swapi_data(endpoint):
    base_url = "https://swapi.dev/api/"
    url = f"{base_url}{endpoint}/"

    response = requests.get(url)

    if response.status_code == 200:
        json_object = json.loads(response.content)
        json_formatted_str = json.dumps(json_object, indent=2)
        print(json_formatted_str)
    else:
        print(f"Failed to fetch data from SWAPI. Status code: {response.status_code}")


def check_all_endpoints():
    endpoints = ["films", "people", "planets", "species", "starships", "vehicles"]
    for endpoint in endpoints:
        get_swapi_data(endpoint)


check_all_endpoints()
