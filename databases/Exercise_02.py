'''
Using sqlalchemy which the necessary code to:

- Select all the actors with the first name of your choice

- Select all the actors and the films they have been in

- Select all the actors that have appeared in a category of you choice comedy

- Select all the comedic films and that and sort them by rental rate

- Using one of the statements above, add a GROUP BY

- Using on of the statements above, add a ORDER BY

'''
import sqlalchemy
from pprint import pprint

engine = sqlalchemy.create_engine('mysql+pymysql://root:mydogisachub933@localhost/sakila')
connection = engine.connect()
metadata = sqlalchemy.MetaData()

query = sqlalchemy.select([actor]).where(actor.columns.first_name == 'Harry')
query1 = sqlalchemy.select([actor]).where(actor.columns.first_name.in_(["Harry", "film"]))
query2 = sqlalchemy.select([actor]).where(actor.columns.first_name.in_(["comedy"]))
query3 = sqlalchemy.select([actor]).group_by(sqlalchemy.asc.(film.columns.actor))
query4 = sqlalchemy.select([actor]).order_by(sqlalchemy.asc.(film.columns.actor))
pprint(query)
pprint(query1)
pprint(query2)
pprint(query3)
pprint(query4)
