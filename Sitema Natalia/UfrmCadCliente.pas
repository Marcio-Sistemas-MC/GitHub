unit UfrmCadCliente;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Buttons, ExtCtrls, DB, Mask, DBCtrls;

type
  TfrmCadCliente = class(TForm)
    pnlCliente: TPanel;
    btnAlterar: TBitBtn;
    btnCancelar: TBitBtn;
    btnExcluir: TBitBtn;
    btnSalvar: TBitBtn;
    btnLocalizar: TBitBtn;
    btnSair: TBitBtn;
    Label1: TLabel;
    DBEdit1: TDBEdit;
    dtsCadCliente: TDataSource;
    Label2: TLabel;
    DBEdit2: TDBEdit;
    Label3: TLabel;
    DBEdit3: TDBEdit;
    Label4: TLabel;
    DBEdit4: TDBEdit;
    Label5: TLabel;
    DBEdit5: TDBEdit;
    Label6: TLabel;
    DBEdit6: TDBEdit;
    Label7: TLabel;
    DBEdit7: TDBEdit;
    Label8: TLabel;
    DBEdit8: TDBEdit;
    Label9: TLabel;
    DBEdit9: TDBEdit;
    Label10: TLabel;
    DBEdit10: TDBEdit;
    Label11: TLabel;
    DBEdit11: TDBEdit;
    Label12: TLabel;
    DBEdit12: TDBEdit;
    Label13: TLabel;
    DBEdit13: TDBEdit;
    DBEdit14: TDBEdit;
    Label14: TLabel;
    DBEdit15: TDBEdit;
    Label15: TLabel;
    Label16: TLabel;
    DBEdit16: TDBEdit;
    btnNovo: TBitBtn;
    procedure FormCreate(Sender: TObject);
    procedure FormDestroy(Sender: TObject);
    procedure FormCloseQuery(Sender: TObject; var CanClose: Boolean);
    procedure btnNovoClick(Sender: TObject);
    procedure btnAlterarClick(Sender: TObject);
    procedure btnCancelarClick(Sender: TObject);
    procedure btnExcluirClick(Sender: TObject);
    procedure btnSalvarClick(Sender: TObject);
    procedure btnSairClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmCadCliente: TfrmCadCliente;

implementation

uses UdmCliente;

{$R *.dfm}

procedure TfrmCadCliente.FormCreate(Sender: TObject);
begin
  if not assigned(dmCliente) then
      dmCliente := TDmCliente.Create(self);
  dmCliente.cdsCadCliente.Open;
end;

procedure TfrmCadCliente.FormDestroy(Sender: TObject);
begin
  dmCliente.Free;
  dmCliente := nil;
end;

procedure TfrmCadCliente.FormCloseQuery(Sender: TObject;
  var CanClose: Boolean);
begin
  dmCliente.cdsCadCliente.Close;
end;

procedure TfrmCadCliente.btnNovoClick(Sender: TObject);
begin
  dmCliente.cdsCadCliente.Append;
  btnSalvar.Enabled := True;
  btnAlterar.Enabled := False;
  btnCancelar.Enabled := True;
  btnExcluir.Enabled := False;
  btnNovo.Enabled := False;
  btnLocalizar.Enabled := False;
  btnSair.Enabled := False;
end;

procedure TfrmCadCliente.btnAlterarClick(Sender: TObject);
begin
  dmCliente.cdsCadCliente.Edit;
  btnSalvar.Enabled := True;
  btnAlterar.Enabled := False;
  btnCancelar.Enabled := True;
  btnExcluir.Enabled := False;
  btnNovo.Enabled := False;
  btnLocalizar.Enabled := False;
  btnSair.Enabled := False;
end;

procedure TfrmCadCliente.btnCancelarClick(Sender: TObject);
begin
  dmCliente.cdsCadCliente.Cancel;
  dmCliente.cdsCadCliente.CancelUpdates;
  btnSalvar.Enabled := False;
  btnAlterar.Enabled := False;
  btnCancelar.Enabled := False;
  btnExcluir.Enabled := False;
  btnNovo.Enabled := True;
  btnLocalizar.Enabled := True;
  btnSair.Enabled := True;
end;

procedure TfrmCadCliente.btnExcluirClick(Sender: TObject);
begin
  dmCliente.cdsCadCliente.Delete;
  if (dmCliente.cdsCadCliente.ApplyUpdates(0)<> 0) then
    dmCliente.cdsCadCliente.CancelUpdates;
  btnSalvar.Enabled := False;
  btnAlterar.Enabled := False;
  btnCancelar.Enabled := False;
  btnExcluir.Enabled := False;
  btnNovo.Enabled := True;
  btnLocalizar.Enabled := True;
  btnSair.Enabled := True;
end;

procedure TfrmCadCliente.btnSalvarClick(Sender: TObject);
begin
  dmCliente.cdsCadCliente.Post;
  if (dmCliente.cdsCadCliente.ApplyUpdates(0) <> 0) then
    dmCliente.cdsCadCliente.CancelUpdates;
  btnSalvar.Enabled := False;
  btnAlterar.Enabled := False;
  btnCancelar.Enabled := False;
  btnExcluir.Enabled := False;
  btnNovo.Enabled := True;
  btnLocalizar.Enabled := True;
  btnSair.Enabled := True;
end;

procedure TfrmCadCliente.btnSairClick(Sender: TObject);
begin
  close;
end;

end.
