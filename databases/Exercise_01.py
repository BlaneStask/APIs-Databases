'''

All of the following exercises should be done using sqlalchemy.

Using the dvdrental schema, write the necessary code to print information about the film and category table.

'''
import sqlalchemy
from pprint import pprint

engine = sqlalchemy.create_engine('mysql+pymysql://root:mydogisachub933@localhost/sakila')
connection = engine.connect()
metadata = sqlalchemy.MetaData()

dvd_rental = sqlalchemy.Table('film', metadata, autoload=True, autoload_with=engine)
dvd_rental_ = sqlalchemy.Table('category', metadata, autoload=True, autoload_with=engine)
pprint(dvd_rental)
