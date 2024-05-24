from pathlib import Path
import ttkbootstrap as ttk
from ttkbootstrap.constants import *
from ttkbootstrap.dialogs import Messagebox
from util.util import Util


CAMINHO_IMAGEM = Path(__file__).parent / 'res'


class Main_Paluh(ttk.Frame):


    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.util = Util()
        self.criarJanela()

    def criarJanela(self):
        x = (self.winfo_screenwidth() // 2) - (self.util.larguraTela // 2)
        y = (self.winfo_screenheight() // 2) - (self.util.alturaTela // 2)

        self.pack(fill=BOTH, expand=YES)

        self.master.geometry("{}x{}+{}+{}".format(self.util.larguraTela, self.util.alturaTela, x, y))
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

        # painel central
        painelCentral = ttk.Frame(self, padding=(1, 1), bootstyle="light")
        painelCentral.pack(side=TOP, fill=BOTH, expand=YES)

        textoSelecioneTeste = "Selecione o teste"
        self.frameSelecioneTeste = ttk.Labelframe(painelCentral, text=textoSelecioneTeste, bootstyle="dark")

        self.frameTestesNormalidadeHipoteses = ttk.Frame(self.frameSelecioneTeste, bootstyle="light")
        self.frameTestesNormalidadeHipoteses.pack(fill=BOTH, expand=Y, anchor=N)

        self.labelNormalidade = ttk.Label(self.frameTestesNormalidadeHipoteses, text="Testes de Normalidade:", width=50)
        self.labelNormalidade.place(x=30, y=30)

        botaoTesteNormalidade = ttk.Button(
            master=self.frameTestesNormalidadeHipoteses,
            text="Normalidade",
            command=lambda: self.openJanelaNormalidade(),
            bootstyle=INFO,
            width=25
        )
        botaoTesteNormalidade.place(x=50, y=80)

        self.labelHipotese = ttk.Label(self.frameTestesNormalidadeHipoteses, text="Testes de Hipótese:", width=50)
        self.labelHipotese.place(x=30, y=130)

        botaoTesteHipoteseParametrico2Grupos = ttk.Button(
            master=self.frameTestesNormalidadeHipoteses,
            text="Paramétrico 2 Grupos",
            command=lambda: self.openJanelaHipoteseParametrico2Grupos(),
            bootstyle=PRIMARY,
            width=25
        )
        botaoTesteHipoteseParametrico2Grupos.place(x=50, y=180)

        botaoTesteHipoteseParametricoMais2Grupos = ttk.Button(
            master=self.frameTestesNormalidadeHipoteses,
            text="Paramétrico > 2 Grupos",
            command=lambda: self.openJanelaHipoteseParametricoMais2Grupos(),
            bootstyle=PRIMARY,
            width=25
        )
        botaoTesteHipoteseParametricoMais2Grupos.place(x=250, y=180)

        botaoTesteHipoteseNaoParametrico2Grupos = ttk.Button(
            master=self.frameTestesNormalidadeHipoteses,
            text="Não Paramétrico 2 Grupos",
            command=lambda: self.openJanelaHipoteseNaoParametrico2Grupos(),
            bootstyle=PRIMARY,
            width=25
        )
        botaoTesteHipoteseNaoParametrico2Grupos.place(x=50, y=230)

        botaoTesteHipoteseNaoParametricoMais2Grupos = ttk.Button(
            master=self.frameTestesNormalidadeHipoteses,
            text="Não Paramétrico > 2 Grupos",
             command=lambda: self.openJanelaHipoteseNaoParametricoMais2Grupos(),
            bootstyle=PRIMARY,
            width=25
        )
        botaoTesteHipoteseNaoParametricoMais2Grupos.place(x=250, y=230)

        self.frameSelecioneTeste.pack_forget()

    def openJanelaHipoteseParametricoMais2Grupos(self):
        pass
    def openJanelaHipoteseNaoParametricoMais2Grupos(self):
        pass

    def openJanelaNormalidade(self):
        pass

    def openJanelaHipoteseParametrico2Grupos(self):
        pass

    def openJanelaHipoteseNaoParametrico2Grupos(self):
        pass

    def showAbrirArquivo(self):
        self.frameSelecioneTeste.pack(fill=BOTH, expand=YES, anchor=N)

    def showSobre(self):
        mensagem = "Paluh - Privacidade Aluh tem como objetivo o desenvolvimento de aplicação para a descoberta e anonimização (tarjamento) de dados pessoais em documentos textuais no formato PDF.\n Contato: albertfrancajosuacosta@gmail.com"
        Messagebox.show_info(mensagem, title='Sobre', alert=True, parent=self)


if __name__ == '__main__':
    app = ttk.Window()
    Main_Paluh(app)
    app.mainloop()
