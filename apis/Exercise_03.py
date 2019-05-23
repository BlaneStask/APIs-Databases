'''
Write the necessary code to make a POST request to:

    http://demo.codingnomads.co:8080/tasks_api/users

and create a user with your information.

Make a GET request to confirm that your user information has been saved.

'''
import requests
from pprint import pprint
base_url = "http://demo.codingnomads.co:8080/tasks_api/users"
user = {
    "Apples": "Red",
    "Bananas": "Yellow",
    "Oranges": "Orange"
}

response = requests.post(base_url, json=user)
pprint(response)
