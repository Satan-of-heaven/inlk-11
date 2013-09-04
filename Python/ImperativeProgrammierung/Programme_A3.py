##################################################
### Inf-Schule : Programme, Uebungen, Aufgabe 3 ##
##################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/programme/uebungen

############################################
################ORIGINAL####################

### Eingabe
###kapital  = input('Kapital (in Euro):')
### Verarbeitung
###zinssatz = 2.0%
###zinsen = kapital * zinssatz
###kapital = kapital + zinsen
### Ausgabe
###print('neues kapital: kapital')

##############################################

# Eingabe
#!# Typkonvertierung fehlt
kapital  = float(input('Kapital (in Euro):'))
# Verarbeitung
#!# Zinssatz in %
zinssatz = 2.0
zinsen = kapital * zinssatz
kapital = kapital + zinsen
# Ausgabe
#!# Stringverkettung falsch
print('neues kapital:' + str(kapital))
