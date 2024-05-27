import fitz
from tkinter import *
from PIL import Image, ImageTk

# open pdf file
file_name = r"C:\Users\alber\Documents\LabMax\Paluh\Currículos Lattes - Albert França Josuá Costa.pdf"
doc = fitz.open(file_name)

# transformation matrix we can apply on pages
zoom = 1.5
mat = fitz.Matrix(zoom, zoom)

# count number of pages
num_pages = 0
for p in doc:
    num_pages += 1

# initialize and set screen size
root = Tk()
root.geometry('750x700')

# add scroll bar
scrollbar = Scrollbar(root)
scrollbar.pack(side = RIGHT, fill = Y)

# add canvas
canvas = Canvas(root, yscrollcommand = scrollbar.set)
canvas.pack(side = LEFT, fill = BOTH, expand = 1)

# define entry point (field for taking inputs)
entry = Entry(root)

# add a label for the entry point
label = Label(root, text="Enter page number to display:")

def pdf_to_img(page_num):
    page = doc.load_page(page_num)
    pix = page.get_pixmap(matrix=mat)

    return Image.frombytes("RGB", [pix.width, pix.height], pix.samples)

def show_image():
    try:
        page_num = int(entry.get()) - 1
        assert page_num >= 0 and page_num < num_pages
        im = pdf_to_img(page_num)
        img_tk = ImageTk.PhotoImage(im)
        frame = Frame(canvas)
        panel = Label(frame, image=img_tk)
        panel.pack(side="bottom", fill="both", expand="yes")
        frame.image = img_tk
        canvas.create_window(0, 0, anchor='nw', window=frame)
        frame.update_idletasks()
        canvas.config(scrollregion=canvas.bbox("all"))
    except:
        pass

# add button to display pages
button = Button(root, text="Show Page", command=show_image)

# set visual locations
label.pack(side=TOP, fill=None)
entry.pack(side=TOP, fill=BOTH)
button.pack(side=TOP, fill=None)

entry.insert(0, '1')
show_image()

scrollbar.config(command = canvas.yview)
root.mainloop()

doc.close()