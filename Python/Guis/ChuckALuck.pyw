from tkinter import *
from random import *


def btn_zahlen_Clicked():
    einsatz = int(txt_zahl.cget("text"))
    btn_wuerfeln.config(state="normal")
    btn_zahlen.config(state="disabled")
        
def btn_auszahlen_Clicked():
    pass

def btn_wuerfeln_Clicked():
    lbl_w1.config(text=str(randint(1,6)))
    lbl_w2.config(text=str(randint(1,6)))
    lbl_w3.config(text=str(randint(1,6)))

win = Tk()
win.title("Chuck a Luck")
win.geometry("500x170")

frm_labels = Frame(master=win)
frm_einaus = Frame(master=win)
frm_buttons = Frame(master=win)

lbl_ueberschrift =  Label(master=win, text="Chuck a Luck", fg="#FFFFFF", bg="#C4C4C4", font=("Arial", 20))
lbl_konto = Label(master=frm_labels, text="Konto", fg="#000000", bg="#FF78A5")
lbl_zahl = Label(master=frm_labels, text="Zahl", fg="#000000", bg="#B0FA55")
lbl_wuerfel = Label(master=frm_labels, text="Würfel", fg="#000000", bg="#FFB300")
lbl_w1 = Label(master=frm_einaus, text="-1", fg="#000000", bg="#FFB300")
lbl_w2 = Label(master=frm_einaus, text="-1", fg="#000000", bg="#FFB300")
lbl_w3 = Label(master=frm_einaus, text="-1", fg="#000000", bg="#FFB300")
lbl_kontostand = Label(master=frm_einaus, text="100", fg="#000000", bg="#FF78A5")
txt_zahl = Entry(master=frm_einaus)
btn_zahlen = Button(master=frm_buttons, text="Einsatz zahlen", fg="#000000", bg="#C9C9C9", command=btn_zahlen_Clicked)
btn_auszahlen = Button(master=frm_buttons, text="Gewinn auszahlen", fg="#000000", bg="#C9C9C9", state="disabled", command=btn_auszahlen_Clicked)
btn_wuerfeln = Button(master=frm_buttons, text="Würfel werfen", fg="#000000", bg="#C9C9C9", state="disabled", command=btn_wuerfeln_Clicked)


lbl_ueberschrift.pack(side="top", fill="both", padx=5, pady=5)

lbl_konto.pack(side="left", fill="x", padx=5, pady=5, expand=True)
lbl_zahl.pack(side="left", fill="x", padx=5, pady=5, expand=True)
lbl_wuerfel.pack(side="left", fill="x", padx=5, pady=5, expand=True)

frm_labels.pack(side="top", fill="both", expand=True)

lbl_kontostand.pack(side="left", fill="x", padx=25, pady=5)
txt_zahl.pack(side="left", fill="x", padx=25, pady=5)
lbl_w1.pack(side="right", fill="x", padx=5, pady=5)
lbl_w2.pack(side="right", fill="x", padx=5, pady=5)
lbl_w3.pack(side="right", fill="x", padx=5, pady=5)

frm_einaus.pack(side="top", fill="x", expand=True)

btn_zahlen.pack(side="left", fill="x", padx=5, pady=5, expand=True)
btn_auszahlen.pack(side="left", fill="x", padx=5, pady=5, expand=True)
btn_wuerfeln.pack(side="left", fill="x", padx=5, pady=5, expand=True)

frm_buttons.pack(side="top", fill="x", expand=True)

#lbl_ueberschrift.place(x=5, y=5, width=490, height=50)

#lbl_konto.place(x=5, y=60, width=160, height=30)
#lbl_zahl.place(x=170, y=60, width=160, height=30)
#lbl_wuerfel.place(x=335, y=60, width=160, height=30)

#lbl_kontostand.place(x=70, y=95 , width=30, height=30)
#txt_zahl.place(x= 240, y= 95, width=30, height=30)
#lbl_w1.place(x=335 , y=95, width=30, height=30)
#lbl_w2.place(x=400 , y=95, width=30, height=30)
#lbl_w3.place(x=465 , y=95, width=30, height=30)

#btn_zahlen.place(x=5 ,y=135, width=160, height=30)
#btn_auszahlen.place(x=170 ,y=135, width=160, height=30)
#btn_wuerfeln.place(x=335 ,y=135, width=160, height=30)

win.mainloop()
