# EL open para abrir el fichero junto al nombre del fichero y 
# la "w" para escribir en el fichero y la a para añadir al fichero
file = open("clients_sequencial.txt","a")

# Escribimos en el fichero
file.write("12345678,Joan,Gonzalez,654321789\n")
file.write("87654321,Ana,Martinez,987654321\n")
file.write("13579246,Lluís,Rodriguez,564738291\n")
file.write("24681357,Maria,Perez,987654765\n")


# Cerramos el fichero
file.close()

# Abrimos el fichero en modo lectura
file = open("clients_sequencial.txt","r")

# Leemos el fichero
print(file.read())