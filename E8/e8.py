from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__) 

caminho = os.path.dirname(os.path.abspath(__file__))

arquivobd = os.path.join(caminho, 'produtos.db')

if os.path.exists(arquivobd):
        os.remove(arquivobd)

app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///" + arquivobd

db = SQLAlchemy(app) 

with app.app_context():


    class Produto(db.Model):
        id = db.Column(db.Integer, primary_key=True)
        nome = db.Column(db.Text)
        preco = db.Column(db.Integer)
        marca = db.Column(db.Text)

        def __str__(self):
            return f'(id={self.id}) {self.nome}, '+\
                f'{self.preco}, {self.marca}'

    db.create_all()

    produto = Produto(nome = "MicroSD", preco = 20, marca = "SanDisk")    
    produto2 = Produto(nome = "teclado", preco = 50, marca = "redragon")   

    db.session.add(produto)
    db.session.add(produto2)
    db.session.commit()

    #Mostrar todos
    produtos = Produto.query.all()
    for p in produtos:
        print(p)
    print("")

    #Filtrar
    p = Produto.query.filter_by(id=1).first()
    print(p)

    #Alterar
    p = Produto.query.filter_by(id=2).first()
    p.preco = 9
    db.session.commit()

    #Excluir
    p = Produto.query.filter_by(id=1).first()
    db.session.delete(p)
    db.session.commit()
    print("")

    produtos = Produto.query.all()
    for p in produtos:
        print(p)

