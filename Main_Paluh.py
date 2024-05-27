
from pathlib import Path
from tkinter import filedialog, Scrollbar, Canvas
import ttkbootstrap as ttk
from qtconsole.mainwindow import background
from ttkbootstrap.constants import *
from ttkbootstrap.dialogs import Messagebox
from util.util import Util
from PIL import Image, ImageTk
import fitz

CAMINHO_IMAGEM = Path(__file__).parent / 'res'


class Main_Paluh(ttk.Frame):


    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.caminhoArquivo=""
        self.util = Util()
        self.criarJanela()



    def criarJanela(self):
        x = (self.winfo_screenwidth() // 2) - (self.util.larguraTela // 2)
        y = (self.winfo_screenheight() // 2) - (self.util.alturaTela // 2)

        largura = self.winfo_screenwidth()
        altura = self.winfo_screenheight()
        self.pack(fill=BOTH, expand=YES)

        self.master.geometry("{}x{}+{}+{}".format(self.util.larguraTela, self.util.alturaTela, x, y))
        #self.master.geometry("%dx%d" % (largura, altura))

        self.master.title("Paluh - Privacidade Aluízio - Versão " + str(self.util.versao_0_1))
        self.master.iconbitmap(CAMINHO_IMAGEM.__str__() + "\\Pouca-Sombra.ico")

        self.photoimages = []
        imgpath = Path(__file__).parent / 'res'

        for key, val in self.util.arquivo_imagem.items():
            _path = imgpath / val
            self.photoimages.append(ttk.PhotoImage(name=key, file=_path))

        # buttonbar
        buttonbar = ttk.Frame(self, style='primary.TFrame')
        buttonbar.pack(fill=X, pady=1, side=TOP)

        ## new backup
        _func = lambda: self.showAbrirArquivo()
        btn = ttk.Button(
            master=buttonbar,
            text='Abrir...',
            image='abrir',
            compound=LEFT,
            command=_func
        )
        btn.pack(side=LEFT, ipadx=5, ipady=5, padx=(1, 0), pady=1)

        ## backup
        _func = lambda: self.showSobre()
        btn = ttk.Button(
            master=buttonbar,
            text='Sobre',
            image='sobre',
            compound=LEFT,
            command=_func
        )
        btn.pack(side=LEFT, ipadx=5, ipady=5, padx=0, pady=1)

        ## refresh
        _func = lambda: self.master.destroy()
        btn = ttk.Button(
            master=buttonbar,
            text='Sair',
            image='sair',
            compound=LEFT,
            command=_func
        )
        btn.pack(side=LEFT, ipadx=5, ipady=5, padx=0, pady=1)

        # open pdf file
        self.doc = None
        # count number of pages
        self.qtdPaginas = 0




        #painel Esquerdo
        self.painelEsquerdo = ttk.Frame(self, style='dander.TFrame')
        self.painelEsquerdo.pack(side=ttk.LEFT, expand=True, fill=X)

        # add scroll bar
        #self.scrollbar = Scrollbar(self.painelEsquerdo)
        #self.scrollbar.pack(side=RIGHT, fill=BOTH)

        # add canvas
        #self.canvas = Canvas(self.painelEsquerdo, yscrollcommand=self.scrollbar.set)
        self.canvas = Canvas(self.painelEsquerdo)

        #self.canvas.configure(height=self.painelEsquerdo.winfo_screenheight())
        self.canvas.pack(side=LEFT, fill=BOTH, expand=True)


        #painel Direito
        self.painelDireito = ttk.Frame(self, style='danger.TFrame')
        self.painelDireito.pack(side=RIGHT, fill=BOTH, expand=True)

        textoOpcesBusca = "Opções de busca"
        self.frameOpcoesBusca = ttk.Labelframe(self.painelDireito, text=textoOpcesBusca, bootstyle="dark")
        self.frameOpcoesBusca.pack(fill=BOTH, expand=YES, anchor=N)


        self.arquivSelecionado = ttk.Label(
            text="Arquivo selecionado: ",
            master=self.frameOpcoesBusca
        )
        self.arquivSelecionado.place(x=10,y=10)

        self.labelQtdPaginas = ttk.Label(
            text="Quantidade de páginas: ",
            master=self.frameOpcoesBusca
        )
        self.labelQtdPaginas.place(x=10, y=40)






        textoResultadoDescoberta = "Resultado descoberta"
        self.frameResultadoDescoberta = ttk.Labelframe(self.painelDireito, text=textoResultadoDescoberta, bootstyle="dark")
        self.frameResultadoDescoberta.pack(fill=BOTH, expand=YES, anchor=N)

        textoResultadoTarjamento = "Resultado tarjamento"
        self.frameResultadoTarjamento = ttk.Labelframe(self.painelDireito, text=textoResultadoTarjamento, bootstyle="dark")
        self.frameResultadoTarjamento.pack(fill=BOTH, expand=YES, anchor=N)




        self.painelEsquerdo.pack_forget()
        self.painelDireito.pack_forget()


    def showAbrirArquivo(self):

        self.caminhoArquivo = filedialog.askopenfilename(title="Selecione o arquivo", filetypes=[("PDF Files", "*.pdf")])

        self.doc = fitz.open(self.caminhoArquivo)

        self.qtdPaginas = self.doc.page_count


        self.arquivSelecionado.config(text="Arquivo selecionado: \n"+self.caminhoArquivo)
        self.labelQtdPaginas.config(text="Quantidade de páginas: \n" + str(self.qtdPaginas))
       # self.setvar('qtdPaginas', self.doc.page_count)

        self.show_image()

        self.painelEsquerdo.pack(side=LEFT, expand=True, fill=X)
        self.painelDireito.pack(side=RIGHT, fill=BOTH, expand=True)
        self.labelQtdPaginas.update_idletasks()
        self.labelQtdPaginas.update()

        self.doc.save("dddd.pdf")


    def showSobre(self):
        mensagem = "Paluh - Privacidade Aluh tem como objetivo o desenvolvimento de aplicação para a descoberta e anonimização (tarjamento) de dados pessoais em documentos textuais no formato PDF.\n Contato: albertfrancajosuacosta@gmail.com"
        percentagemLargura = int((self.util.larguraTela//2)*0.50)
        Messagebox.show_info(mensagem, title='Sobre', alert=True, parent=self, position=((self.util.larguraTela//2)+percentagemLargura,self.util.alturaTela//2))


    def pdf_to_img(self,page_num):
       self.zoom = 1.0
       self.mat = fitz.Matrix(self.zoom, self.zoom)
       page = self.doc.load_page(page_num)
       #a = page.search_for("Jaime")
       #page.add_highlight_annot(a[0])
       #anotacao = page.add_rect_annot(a[0])
       #anotacao.set_color(fill="black")
       #anotacao.update()
       #print('=======')
       #print(a)
       #print(page.get_text("text"))
       pix = page.get_pixmap(matrix=self.mat)


       return Image.frombytes("RGB", [pix.width, pix.height], pix.samples)

    def show_image(self):
        try:
            #page_num = int(entry.get()) - 1
            page_num = 0
            assert page_num >= 0 and page_num < self.qtdPaginas
            im = self.pdf_to_img(page_num)
            img_tk = ImageTk.PhotoImage(im)
            frame = ttk.Frame(self.canvas)



            #panel = ttk.Label(frame, image=img_tk)
            panel = ttk.Label(frame,image=img_tk,relief="solid")
            panel.pack(fill=Y,expand=YES)
            #panel.pack(side="bottom", fill="both", expand="yes")
            frame.image = img_tk
            self.canvas.create_window(0, 0, anchor='nw', window=frame)
            frame.update_idletasks()
            frame.pack(side="left", fill="both", expand="yes")
            #frame.grid(column=0, row=0)

            self.canvas.config(scrollregion=self.canvas.bbox("all"))
        except:
            pass

if __name__ == '__main__':
    app = ttk.Window()
    Main_Paluh(app)
    app.mainloop()
