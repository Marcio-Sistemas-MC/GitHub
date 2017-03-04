object dmPrincipal: TdmPrincipal
  OldCreateOrder = False
  Left = 715
  Top = 248
  Height = 150
  Width = 237
  object sqlConSisComercial: TSQLConnection
    ConnectionName = 'SisComercial'
    DriverName = 'Interbase'
    GetDriverFunc = 'getSQLDriverINTERBASE'
    LibraryName = 'dbexpint.dll'
    LoginPrompt = False
    Params.Strings = (
      'DriverName=Interbase'
      
        'Database=E:\Documentos\GitHub\Projetos\Documenta'#231#227'o\sistemaVenda' +
        's.fdb'
      'RoleName=RoleName'
      'User_Name=sysdba'
      'Password=masterkey'
      'ServerCharSet=WIN1254'
      'SQLDialect=3'
      'BlobSize=-1'
      'CommitRetain=False'
      'WaitOnLocks=True'
      'ErrorResourceFile='
      'LocaleCode=0000'
      'Interbase TransIsolation=ReadCommited'
      'Trim Char=False')
    VendorLib = 'gds32.dll'
    Connected = True
    Left = 24
    Top = 16
  end
end
