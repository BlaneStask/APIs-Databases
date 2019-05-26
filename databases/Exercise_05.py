'''
Using the API from the API section, write a program that makes a request to
get all of the users and all of their tasks.

Create tables in a new local database to model this data.

Think about what tables are required to model this data. Do you need two tables? Three?

Persist the data returned from the API to your database.

NOTE: If you run this several times you will be saving the same information in the table.
To prevent this, you should add a check to see if the record already exists before inserting it.

'''
import requests
from pprint import pprint

base_url = "mysql+pymysql://root:mydogisachub933@localhost/sakila"

response = requests.get(base_url)
pprint(response.users)
pprint(response.tasks)

base_url_2 = "mysql+pymysql://root:mydogisachub933@localhost/lab05"

user = {
    "id": response.id,
    "name": response.users
}

response = requests.post(base_url_2, json=user)

tasks = {
    "id": response.id,
    "tasks": response.tasks
}

response = requests.post(base_url_2, json=tasks)
