'''

Please create a new Python application that interfaces with a brand new database.
This application must demonstrate the ability to:

    - create at least 3 tables
    - insert data to each table
    - update data in each table
    - select data from each table
    - delete data from each table
    - use at least one join in a select query

BONUS: Make this application something that a user can interact with from the CLI. Have options
to let the user decide what tables are going to be created, or what data is going to be inserted.
The more dynamic the application, the better!


'''
import sqlalchemy
from pprint import pprint

engine = sqlalchemy.create_engine('mysql+pymysql://root:mydogisachub9336@localhost/sakila')
connection = engine.connect()
metadata = sqlalchemy.MetaData()

fruit_table = sqlalchemy.Table('Fruits', metadata,
                             sqlalchemy.column('Id', sqlalchemy.Integer()),
                             sqlalchemy.column('name', sqlalchemy.String(30), nullable=False),
                             sqlalchemy.column('price', sqlalchemy.Integer(), default=0.50),
                             sqlalchemy.column('active', sqlalchemy.Boolean(), default=True))
veg_table = sqlalchemy.Table('Vegetables', metadata,
                             sqlalchemy.column('Id', sqlalchemy.Integer()),
                             sqlalchemy.column('name', sqlalchemy.String(30), nullable=False),
                             sqlalchemy.column('price', sqlalchemy.Integer(), default=1.00),
                             sqlalchemy.column('active', sqlalchemy.Boolean(), default=True))
meat_table = sqlalchemy.Table('Meats', metadata,
                             sqlalchemy.column('Id', sqlalchemy.Integer()),
                             sqlalchemy.column('name', sqlalchemy.String(30), nullable=False),
                             sqlalchemy.column('price', sqlalchemy.Integer(), default=5.00),
                             sqlalchemy.column('active', sqlalchemy.Boolean(), default=True))

metadata.creat_all(engine)

query1 = sqlalchemy.insert(fruit_table).values(Id=1, name='Apple', price=1.50)
query2 = sqlalchemy.insert(veg_table).values(Id=1, name='Carrot', price=3.00)
query3 = sqlalchemy.insert(meat_table).values(Id=1, name='Chicken', price=10.00)

result_proxy1 = connection.execute(query1)
result_proxy2 = connection.execute(query2)
result_proxy3 = connection.execute(query3)

query4 = sqlalchemy.update(fruit_table).values(price=1.00).where(fruit_table.columns.Id == 1)
query5 = sqlalchemy.update(veg_table).values(price=2.00).where(veg_table.columns.Id == 1)
query6 = sqlalchemy.update(meat_table).values(price=12.00).where(meat_table.columns.Id == 1)

result_proxy4 = connection.execute(query4)
result_proxy5 = connection.execute(query5)
result_proxy6 = connection.execute(query6)

query7 = sqlalchemy.select(fruit_table).where(fruit_table.columns.name == 'Apple')
query8 = sqlalchemy.select(veg_table).where(veg_table.columns.name == 'Carrot')
query9 = sqlalchemy.select(meat_table).where(meat_table.columns.name == 'Chicken')

join_fruit_vegetable = fruit.join(vegetable_fruit, vegetable_fruit.columns.fruit_id == fruit.columns.fruit_id)
join_statement = join_fruit_vegetable_fruit.join(vegetable, vegetable.columns.vegetable_id == vegetable_fruit.columns.vegetable_id)
query10 = sqlalchemy.select([meat_table.columns.name, fruit_table.columns.name]).select_from(join_statement)

result_proxy = connection.execute(query10)
result_set = result_proxy.fetchall()
pprint(result_set)

query11 = sqlalchemy.delete(fruit_table).where(fruit_table.columns.name == 'Apple')
query12 = sqlalchemy.delete(veg_table).where(veg_table.columns.name == 'Carrot')
query13 = sqlalchemy.delete(meat_table).where(meat_table.columns.name == 'Chicken')

result_proxy11 = connection.execute(query11)
result_proxy12 = connection.execute(query12)
result_proxy13 = connection.execute(query13)
