unit UdmCliente;

interface

uses
  SysUtils, Classes, FMTBcd, Provider, DB, SqlExpr, DBClient;

type
  TdmCliente = class(TDataModule)
    sdsCadCliente: TSQLDataSet;
    dspCadCliente: TDataSetProvider;
    cdsCadCliente: TClientDataSet;
    cdsCadClienteCODCLIENTE: TIntegerField;
    cdsCadClienteNOMECLI: TStringField;
    cdsCadClienteRUACLI: TStringField;
    cdsCadClienteNUMCLI: TIntegerField;
    cdsCadClienteBAIRROCLI: TStringField;
    cdsCadClienteCOMPLEMENTOCLI: TStringField;
    cdsCadClienteCODCIDADE: TIntegerField;
    cdsCadClienteTELEFONE1: TStringField;
    cdsCadClienteTELEFONE2: TStringField;
    cdsCadClienteCELULAR: TStringField;
    cdsCadClienteCEPCLI: TStringField;
    cdsCadClienteEMAIL: TStringField;
    cdsCadClienteDATACADASTRO: TSQLTimeStampField;
    cdsCadClienteDATAATUALIZACAO: TSQLTimeStampField;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  dmCliente: TdmCliente;

implementation

uses UdmPrincipal;

{$R *.dfm}

end.
