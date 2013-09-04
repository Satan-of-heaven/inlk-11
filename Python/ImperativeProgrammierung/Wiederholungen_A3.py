######################################################
## Inf-Schule : Wiederholungen, Uebungen, Aufgabe 3 ##
######################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/wiederholungen/uebungen

#a)

# Eingabe
population = float(input("Population zu Beginn: "))

# Verarbeitung
jahr = 2010
while jahr < 2020:
    population = population * 1.05
	#!# jahr Erhoehung fehlt
    jahr += 1

# Ausgabe
print("Population am Ende:", population)

#b)

# Eingabe
kapital = float(input("Kapital zu Beginn: "))

#!# jahr Deklarierung fehlt
jahr = 2010

# Verarbeitung
while jahr < 2020:
    kapital = kapital * 1.05
    jahr = jahr + 1

# Ausgabe
print("Kapital am Ende:", kapital)
