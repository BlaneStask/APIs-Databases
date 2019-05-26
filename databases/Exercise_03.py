'''
Update all films in the film table to a rental_duration value of 10,
if the length of the movie is more than 150.

'''
import sqlalchemy
from pprint import pprint

engine = sqlalchemy.create_engine('mysql+pymysql://root:mydogisachub9336@localhost/sakila')
connection = engine.connect()
metadata = sqlalchemy.MetaData()

for length in film > 150:
    query = sqlalchemy.update(film).values(film.columns.rental_duration+=10)

pprint(query)
