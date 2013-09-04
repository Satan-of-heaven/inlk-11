from tkinter import *

def wegberechnungen(geschwindigkeit):
    reaktionsweg = (geschwindigkeit/10)*3
    bremsweg = (geschwindigkeit/10) * (geschwindigkeit/10)
    anhalteweg = reaktionsweg + bremsweg
    return (reaktionsweg, bremsweg, anhalteweg)

def Button_Berechnen_Click():
    # Übernahme der Daten
    geschwindigkeit = float(entryGeschwindigkeit.get())
    # Verarbeitung der Daten
    (reaktionsweg, bremsweg, anhalteweg) = wegberechnungen(geschwindigkeit)   
    # Anzeige der Daten
    anzeigeReaktionsweg = '{0:.2f}'. format(reaktionsweg)
    labelWertReaktionsweg.config(text=anzeigeReaktionsweg)
    anzeigeBremsweg = '{0:.2f}'. format(bremsweg)
    labelWertBremsweg.config(text=anzeigeBremsweg)
    anzeigeAnhalteweg = '{0:.2f}'. format(anhalteweg)
    labelWertAnhalteweg.config(text=anzeigeAnhalteweg)

# Erzeugung des Fensters
tkFenster = Tk()
tkFenster.title('Anhalteweg')
tkFenster.geometry('500x287')
# Rahmen für die Überschrift
frameUeberschrift = Frame(master=tkFenster,
                          background='#889E9D')
frameUeberschrift.place(x=5, y=5, width=290, height=45)
# Rahmen für die Eingaben
frameEingaben = Frame(master=tkFenster,
                      background='#D5E88F')
frameEingaben.place(x=5, y=55, width=490, height=72)
# Rahmen für die Verarbeitung
frameVerarbeitung = Frame(master=tkFenster,
                          background='#FBD975')
frameVerarbeitung.place(x=5, y=132, width=490, height=44)
# Rahmen für die Ausgaben
frameAusgaben = Frame(master=tkFenster,
                      background='#FFCFC9')
frameAusgaben.place(x=5, y=181, width=90, height=101)
# Label für die Überschrift
labelUeberschrift = Label(master=frameUeberschrift,
                          background='white',
                          text='Anhalteweg eines Autos')
labelUeberschrift.place(x=50, y=12, width=190, height=20)
# Label mit Aufschrift Geschwindigkeit
labelGeschwindigkeit = Label(master=frameEingaben,
                             background='white',
                             text='Geschwindigkeit [in km/h]')
labelGeschwindigkeit.place(x=10, y=10, width=175, height=20)
# Entry für die Geschwindigkeit
entryGeschwindigkeit = Entry(master=frameEingaben)
entryGeschwindigkeit.place(x=210, y=10, width=60, height=20)
# Label mit Aufschrift geschätzter Anhalteweg
labelGeschaetzterAnhalteweg = Label(master=frameEingaben,
                                    background='white',
                                    text='geschätzer Anhalteweg [in m]')
labelGeschaetzterAnhalteweg.place(x=10, y=40, width=175, height=20)
# Entry für den geschätzten Anhalteweg
entryGeschaetzterAnhalteweg = Entry(master=frameEingaben)
entryGeschaetzterAnhalteweg.place(x=210, y=40, width=60, height=20)
# Button Berechnen
buttonBerechnen = Button(master=frameVerarbeitung,
                         text='berechnen',
                         command=Button_Berechnen_Click)
buttonBerechnen.place(x=95, y=12, width=100, height=20)
# Label mit Aufschrift Reaktionsweg
labelReaktionsweg = Label(master=frameAusgaben,
                          background='white',
                          text='Reaktionsweg [in m]')
labelReaktionsweg.place(x=10, y=10, width=175, height=20)
# Label für den Wert des Reaktionswegs
labelWertReaktionsweg = Label(master=frameAusgaben,
                              background='white',
                              text='')
labelWertReaktionsweg.place(x=210, y=10, width=60, height=20)
# Label mit Aufschrift Bremsweg
labelBremsweg = Label(master=frameAusgaben,
                      background='white',
                      text='Bremsweg [in m]')
labelBremsweg.place(x=10, y=40, width=175, height=20)
# Label für den Wert des Reaktionswegs
labelWertBremsweg = Label(master=frameAusgaben,
                          background='white',
                          text='')
labelWertBremsweg.place(x=210, y=40, width=60, height=20)
# Label mit Aufschrift Anhalteweg
labelAnhalteweg = Label(master=frameAusgaben,
                        background='white',
                        text='Anhalteweg [in m]')
labelAnhalteweg.place(x=10, y=70, width=175, height=20)
# Label für den Wert des Reaktionswegs
labelWertAnhalteweg = Label(master=frameAusgaben,
                            background='white',
                            text='')
labelWertAnhalteweg.place(x=210, y=70, width=60, height=20)

# Aktivierung des Fensters
tkFenster.mainloop()

