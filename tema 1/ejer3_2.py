# Importamos la librería csv
import csv

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