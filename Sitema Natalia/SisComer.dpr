program SisComer;

uses
  Forms,
  UfrmPrincipal in 'UfrmPrincipal.pas' {frmPrincipal},
  UdmPrincipal in 'UdmPrincipal.pas' {DataModule1: TDataModule},
  UdmCliente in 'UdmCliente.pas' {dmCliente: TDataModule},
  UfrmCadCliente in 'UfrmCadCliente.pas' {frmCadCliente};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TfrmPrincipal, frmPrincipal);
  Application.CreateForm(TDataModule1, DataModule1);
  Application.CreateForm(TdmCliente, dmCliente);
  Application.CreateForm(TfrmCadCliente, frmCadCliente);
  Application.Run;
end.
