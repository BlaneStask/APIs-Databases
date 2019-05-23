'''
Write a program that makes a PUT request to update your user information to a new first_name, last_name and email.

Again make a GET request to confirm that your information has been updated.

'''
import requests

base_url = "http://demo.codingnomads.co:8080/tasks_api/users"
user = {
    "id": 11,
    "first_name": "Blane",
    "last_name": "Staskiewicz",
    "email": "bstask@gmail.com"
}

response = requests.put(base_url, json=user)
print(response)
