from faker import Faker
import random

# def llenador():
#   fake = Faker()
  # file = open("./datos.txt","a");
#   file.close()
#   i = 0;
#   while(i!=5000):
#     i = i + 1
#     fake = Faker()
#     nombre = fake.name()
#     job = fake.job()
#     num = random.randint(1200,5000)
#     resultado = nombre+","+job+","+str(num)+"\n"
#     file.write(resultado)

#   print("hecho")
  

# Leedor
def leedor():
  file = open("datos.txt","r")
  print(file.read())
  file.close()
  menu()

# Para modificar un usuario existente
def modificador():
  # Lo ha modificar
  print("Cual es el nombre del empleado")
  nombre = input()
  print("Cual es su nuevo salario")
  newSalario = input()

  # el bucle que detecta la linea donde esta el nombre
  file = open("datos.txt","r")
  i=1
  todo=""
  lineaFind =""
  for linea in file.readlines():
    if nombre in linea:
      lineaFind = linea
      
    if nombre not in linea:
      todo = todo + linea
    i += 1
  file.close()
  
  # La modificacion 
  editar = lineaFind.split(",")
  editar[2] = newSalario
  paEnviar = ",".join(editar)
  
  # el fichero actualizado
  file = open("datosActualizados.txt","w")
  todo = todo + paEnviar
  file.write(todo)
  file.close()
  
# Para añadir un usuario
def anadidor():
  print("Cual es el nombre del nuevo empleado")
  nombre = input()
  print("Cual es su salario")
  newSalario = input()
  print("Cual es su trabajo")
  trabajo = input()
  resultado = nombre+","+trabajo+","+str(newSalario)+"\n"
  file = open("./datos.txt","a");
  file.write(resultado)
  file.close()
  menu()

# Er menúh
def menu():
  print("1. Leer el fichero\n2. Modificar un dato\n3. Añadir un nuevo dato\n4. Salir\n")
  decision = input()
  if(decision == "1"):
    leedor()
  elif(decision == "2"):
    modificador()
  elif(decision == "3"):
    anadidor()
  elif(decision == "4"):
    print("Adios")
  else:
    print("Valor no reconocido")
    menu()
    
menu()