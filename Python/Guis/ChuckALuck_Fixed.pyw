# -*- coding: utf-8 -*-

from tkinter import *
from random import *
#import tkMessageBox


def btn_zahlen_Clicked():
    lbl_w1.config(text="?")
    lbl_w2.config(text="?")
    lbl_w3.config(text="?")

    try :
        zahl = int(txt_zahl.get())
        konto = int(lbl_kontostand.cget("text"))

        if((konto) >= 10):
            if(zahl >  0 and zahl < 7):
                lbl_kontostand.config(text=str(konto - 10))
                txt_zahl.config(state="disabled")
                btn_wuerfeln.config(state="normal")
                btn_zahlen.config(state="disabled")
            else :
                #tkMessageBox.showinfo("Chuck a Luck", "Falsche Zahl eingegeben (muss zwischen 1 und 6 liegen) !")
        else :
            #tkMessageBox.showinfo("Chuck a Luck", "Kein Guthaben mehr !")
            btn_zahlen.config(state="disabled")
            txt_zahl.config(state="disabled")
    except:
        #tkMessageBox.showinfo("Chuck a Luck", "Keine Zahl eingegeben !")

    
        
def btn_auszahlen_Clicked():
    konto = int(lbl_kontostand.cget("text"))
    zahl = int(txt_zahl.get())
    multi = [int(lbl_w1.cget("text")), int(lbl_w2.cget("text")), int(lbl_w3.cget("text"))].count(zahl)

    lbl_kontostand.config(text=str(konto + 10 * multi))   
    
    lbl_w1.config(text="?")
    lbl_w2.config(text="?")
    lbl_w3.config(text="?")
    btn_auszahlen.config(state="disabled")
    btn_zahlen.config(state="normal")
    txt_zahl.config(state="normal")

def btn_wuerfeln_Clicked():
    lbl_w1.config(text=str(randint(1,6)))
    lbl_w2.config(text=str(randint(1,6)))
    lbl_w3.config(text=str(randint(1,6)))

    w = [int(lbl_w1.cget("text")), int(lbl_w2.cget("text")), int(lbl_w3.cget("text"))]
    zahl = int(txt_zahl.get())

    if(zahl in w):
        btn_auszahlen.config(state="normal")
    else :
        btn_zahlen.config(state="normal")
        txt_zahl.config(state="normal")

    btn_wuerfeln.config(state="disabled")
    

win = Tk()
win.title("Chuck a Luck")
win.geometry("500x170")
win.maxsize(500, 170)
win.minsize(500, 170)

lbl_ueberschrift =  Label(master=win, text="Chuck a Luck", fg="#FFFFFF", bg="#C4C4C4", font=("Arial", 20))
lbl_konto = Label(master=win, text="Konto", fg="#000000", bg="#FF78A5")
lbl_zahl = Label(master=win, text="Zahl", fg="#000000", bg="#B0FA55")
lbl_wuerfel = Label(master=win, text="Würfel", fg="#000000", bg="#FFB300")
lbl_w1 = Label(master=win, text="?", fg="#000000", bg="#FFB300")
lbl_w2 = Label(master=win, text="?", fg="#000000", bg="#FFB300")
lbl_w3 = Label(master=win, text="?", fg="#000000", bg="#FFB300")
lbl_kontostand = Label(master=win, text="100", fg="#000000", bg="#FF78A5")
txt_zahl = Entry(master=win)
btn_zahlen = Button(master=win, text="Einsatz zahlen", fg="#000000", bg="#C9C9C9", command=btn_zahlen_Clicked)
btn_auszahlen = Button(master=win, text="Gewinn auszahlen", fg="#000000", bg="#C9C9C9", state="disabled", command=btn_auszahlen_Clicked)
btn_wuerfeln = Button(master=win, text="Würfel werfen", fg="#000000", bg="#C9C9C9", state="disabled", command=btn_wuerfeln_Clicked)


lbl_ueberschrift.place(x=5, y=5, width=490, height=50)

lbl_konto.place(x=5, y=60, width=160, height=30)
lbl_zahl.place(x=170, y=60, width=160, height=30)
lbl_wuerfel.place(x=335, y=60, width=160, height=30)

lbl_kontostand.place(x=70, y=95 , width=30, height=30)
txt_zahl.place(x= 240, y= 95, width=30, height=30)
lbl_w1.place(x=335 , y=95, width=30, height=30)
lbl_w2.place(x=400 , y=95, width=30, height=30)
lbl_w3.place(x=465 , y=95, width=30, height=30)

btn_zahlen.place(x=5 ,y=135, width=160, height=30)
btn_auszahlen.place(x=170 ,y=135, width=160, height=30)
btn_wuerfeln.place(x=335 ,y=135, width=160, height=30)

win.mainloop()
