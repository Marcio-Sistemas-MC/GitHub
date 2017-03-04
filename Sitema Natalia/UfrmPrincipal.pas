unit UfrmPrincipal;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ComCtrls, Menus, ExtCtrls;

type
  TfrmPrincipal = class(TForm)
    MainMenu1: TMainMenu;
    Cadastro1: TMenuItem;
    Cliente1: TMenuItem;
    Fornecedor1: TMenuItem;
    N1: TMenuItem;
    Produto1: TMenuItem;
    CondiesdePagamento1: TMenuItem;
    N2: TMenuItem;
    Produto2: TMenuItem;
    N3: TMenuItem;
    Usurios1: TMenuItem;
    Vendas1: TMenuItem;
    Vender1: TMenuItem;
    Compras1: TMenuItem;
    Pedido1: TMenuItem;
    Relatrios1: TMenuItem;
    Sair1: TMenuItem;
    stbDatahora: TStatusBar;
    Timer1: TTimer;
    procedure Timer1Timer(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    Function DataStatus:String;
  end;

var
  frmPrincipal: TfrmPrincipal;

implementation

{$R *.dfm}

{ TfrmPrincipal }

function TfrmPrincipal.DataStatus: String;
CONST
  Meses:Array[1..12] of String =
    ('Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
      'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro');
  Semana:Array[1..7] of String =
    ('Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira',
      'Quinta-Feira', 'Sexta-Feira', 'Sábado');
var
  Dia, Mes, Ano, DiaSem:Word;
begin
  DecodeDate(Date,Ano,Mes,Dia);
  DiaSem := DayofWeek(Date);
  Result := Semana[DiaSem] + ', ' + InttoStr(dia) + ' de ' + Meses[Mes] + ' de ' + InttoStr(ano);
end;

procedure TfrmPrincipal.Timer1Timer(Sender: TObject);
begin
  stbDatahora.Panels[0].Text := DateToStr(Date);
  stbDatahora.Panels[1].Text := TimeToStr(Time);
  stbDatahora.Panels[2].Text := DataStatus;
end;

end.
