# Importamos la librería csv
import csv
# ===================Metodos========================

# El metodo de buscar
def buscador():
    resultados = []

    # Abrimos el fichero en modo lectura
    with open("clients_sequencial.txt", "r") as file:
        # Leemos el fichero y añadimos los resultados en el array
        reader = csv.reader(file)
        for row in reader:
            resultados.append(row)

    # recorremos el array y mostramos el resultado
    for resultado in resultados:
        if resultado[0] == "12345678":
            print("Cliente encontrado:",resultado[1],resultado[2],", telefono:",resultado[3])
          
#Añadir un usuario al fichero  
def anadidor():
    
    print("Introduce el nombre del usuario")
    nombre = input()#con input() se introducen los valores
    
    print("Introduce el apellido del usuario")
    apellido = input()
    
    print("Introduce el DNI del usuario")
    dni = input()
    
    print("Introduce el telefono del usuario")
    telef = input()
    
    resultado = dni + ","+nombre+","+apellido+","+telef
 
    file = open("clients_sequencial.txt","a")
    file.write(resultado)
  
  
# Mostrar todos los usuarios  
def todo():
    # Abrimos el fichero en modo lectura
    file = open("clients_sequencial.txt","r")

    # Leemos el fichero
    print(file.read())
    
    
#=================El Programa======================   
print("1. Mostrar usuarios\n2. Crear usuario\n3. Mostrar todos los usuarios")
decision = input()

if(decision == "1"):
    buscador()
elif(decision == "2"):
    anadidor()
elif(decision == "3"):
    todo()
else:
    print("no sabes escribir")
