##################################################
### Inf-Schule : Programme, Uebungen, Aufgabe 4 ##
##################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/programme/uebungen

#Eingabe Punkt1
p1X = float(input("Punkt 1 (X-Koordinate) :"))
p1Y = float(input("Punkt 1 (Y-Koordinate) :"))

#Eingabe Punkt2
p2X = float(input("Punkt 2 (X-Koordinate) :"))
p2Y = float(input("Punkt 2 (Y-Koordinate) :"))

#Verarbeitung
#f(x) = mx + n

m = (p2Y - p1Y) / (p2X - p1X)
n = -m * p1X + p1Y

#Ausgabe
print("f(x) = " + str(m) + "x " + ("+ " if n > 0 else "- ") + str(n))
