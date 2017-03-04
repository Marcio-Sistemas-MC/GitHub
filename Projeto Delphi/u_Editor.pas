unit u_Editor;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Menus, ComCtrls, ToolWin, ImgList, ExtCtrls;

type
  Tf_Editor = class(TForm)
    MainMenu1: TMainMenu;
    Arquivo1: TMenuItem;
    Novo1: TMenuItem;
    Abrir1: TMenuItem;
    Salvar1: TMenuItem;
    N1: TMenuItem;
    Sair1: TMenuItem;
    Editar1: TMenuItem;
    Recortar1: TMenuItem;
    Copiar1: TMenuItem;
    Colar1: TMenuItem;
    N2: TMenuItem;
    SelecionarTudo1: TMenuItem;
    Formatar1: TMenuItem;
    Fonte1: TMenuItem;
    PlanodeFundo1: TMenuItem;
    meTexto: TMemo;
    ListaImagens: TImageList;
    ToolBar1: TToolBar;
    btNovo: TToolButton;
    btAbrir: TToolButton;
    btSalvar: TToolButton;
    ToolButton1: TToolButton;
    btRecortar: TToolButton;
    btCopiar: TToolButton;
    btColar: TToolButton;
    BarraStatus: TStatusBar;
    CaixaAbrir: TOpenDialog;
    CaixaSalvar: TSaveDialog;
    CaixaFontes: TFontDialog;
    CaixaCores: TColorDialog;
    Timer1: TTimer;
    procedure FormCreate(Sender: TObject);
    procedure Novo1Click(Sender: TObject);
    procedure meTextoChange(Sender: TObject);
    procedure Abrir1Click(Sender: TObject);
    procedure Salvar1Click(Sender: TObject);
    procedure Fonte1Click(Sender: TObject);
    procedure PlanodeFundo1Click(Sender: TObject);
    procedure Recortar1Click(Sender: TObject);
    procedure Copiar1Click(Sender: TObject);
    procedure Colar1Click(Sender: TObject);
    procedure SelecionarTudo1Click(Sender: TObject);
    procedure Sair1Click(Sender: TObject);
    procedure Timer1Timer(Sender: TObject);
  private
    { Private declarations }
    procedure ExibirHint(Sender: TObject);
    procedure Inicio(Sender: TObject);
  public
    { Public declarations }
  end;

var
  f_Editor: Tf_Editor;

implementation

{$R *.dfm}

procedure Tf_Editor.ExibirHint(Sender: TObject);
begin
  BarraStatus.Panels[0].Text := Application.Hint;
end;

procedure Tf_Editor.Inicio(Sender: TObject);
begin
  meTexto.Clear;
  Recortar1.Enabled := False;
  Copiar1.Enabled := False;
  Colar1.Enabled := False;
  SelecionarTudo1.Enabled := False;
  btRecortar.Enabled := False;
  btCopiar.Enabled := False;
  btColar.Enabled := False;
end;

procedure Tf_Editor.FormCreate(Sender: TObject);
begin
  Application.OnHint := ExibirHint;
  Inicio(Sender);
end;

procedure Tf_Editor.Novo1Click(Sender: TObject);
begin
  Inicio(Sender);
end;

procedure Tf_Editor.meTextoChange(Sender: TObject);
begin
  if meTexto.Text <>'' then
  begin
    Recortar1.Enabled := True;
    Copiar1.Enabled := True;
    SelecionarTudo1.Enabled := True;
    btRecortar.Enabled := True;
    btCopiar.Enabled := True;
  end
  else
  begin
    Recortar1.Enabled := False;
    Copiar1.Enabled := False;
    SelecionarTudo1.Enabled := False;
    btRecortar.Enabled := False;
    btCopiar.Enabled := False;
  end;
end;

procedure Tf_Editor.Abrir1Click(Sender: TObject);
begin
  if CaixaAbrir.Execute then
    meTexto.Lines.LoadFromFile(CaixaAbrir.FileName);
end;

procedure Tf_Editor.Salvar1Click(Sender: TObject);
begin
  if CaixaSalvar.Execute then
    meTexto.Lines.SaveToFile(CaixaSalvar.FileName);
end;

procedure Tf_Editor.Fonte1Click(Sender: TObject);
begin
  if CaixaFontes.Execute then
    meTexto.Font := CaixaFontes.Font;
end;

procedure Tf_Editor.PlanodeFundo1Click(Sender: TObject);
begin
  if CaixaCores.Execute then
    meTexto.Color := CaixaCores.Color;
end;

procedure Tf_Editor.Recortar1Click(Sender: TObject);
begin
  meTexto.CutToClipboard;
  Colar1.Enabled := True;
  btColar.Enabled := True;
end;

procedure Tf_Editor.Copiar1Click(Sender: TObject);
begin
  meTexto.CopyToClipboard;
  Colar1.Enabled := True;
  btColar.Enabled := True;
end;

procedure Tf_Editor.Colar1Click(Sender: TObject);
begin
  meTexto.PasteFromClipboard;
end;

procedure Tf_Editor.SelecionarTudo1Click(Sender: TObject);
begin
  meTexto.SelectAll;
end;

procedure Tf_Editor.Sair1Click(Sender: TObject);
begin
  f_Editor.Close;
end;

procedure Tf_Editor.Timer1Timer(Sender: TObject);
begin
  BarraStatus.Panels[1].Text := DateToStr(Date);
  BarraStatus.Panels[2].Text := TimeToStr(Time);
end;

end.
