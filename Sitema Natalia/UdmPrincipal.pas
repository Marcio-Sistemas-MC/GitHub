unit UdmPrincipal;

interface

uses
  SysUtils, Classes, DBXpress, DB, SqlExpr;

type
  TdmPrincipal = class(TDataModule)
    sqlConSisComercial: TSQLConnection;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  dmPrincipal: TdmPrincipal;

implementation

{$R *.dfm}

end.
