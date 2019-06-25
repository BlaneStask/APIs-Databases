'''

Create an application that interfaces with the user via the CLI - prompt the user with a menu such as:

Please select from the following options (enter the number of the action you'd like to take):
1) Create a new account (POST)
2) View all your tasks (GET)
3) View your completed tasks (GET)
4) View only your incomplete tasks (GET)
5) Create a new task (POST)
6) Update an existing task (PATCH/PUT)
7) Delete a task (DELETE)




'''
#7
import requests

base_url = "http://demo.codingnomads.co:8080/tasks_api/users"

na_first_name = input("To create a new account, Enter your first name: ")
na_last_name = input("Enter your last name: ")
na_email = input("Enter your email: ")

user = {
    "first_name": na_first_name,
    "last_name": na_last_name,
    "email": na_email
}

response = requests.post(base_url, json=user)
print(response)
