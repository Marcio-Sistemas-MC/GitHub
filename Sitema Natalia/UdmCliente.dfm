object dmCliente: TdmCliente
  OldCreateOrder = False
  Left = 535
  Top = 451
  Height = 179
  Width = 255
  object sdsCadCliente: TSQLDataSet
    CommandText = 'select * from cliente'
    MaxBlobSize = -1
    Params = <>
    SQLConnection = DataModule1.sqlConSisComercial
    Left = 24
    Top = 16
  end
  object dspCadCliente: TDataSetProvider
    DataSet = sdsCadCliente
    Left = 72
    Top = 16
  end
  object cdsCadCliente: TClientDataSet
    Aggregates = <>
    Params = <>
    ProviderName = 'dspCadCliente'
    Left = 152
    Top = 16
    object cdsCadClienteCODCLIENTE: TIntegerField
      FieldName = 'CODCLIENTE'
      Required = True
    end
    object cdsCadClienteNOMECLI: TStringField
      FieldName = 'NOMECLI'
      Size = 100
    end
    object cdsCadClienteRUACLI: TStringField
      FieldName = 'RUACLI'
      Size = 100
    end
    object cdsCadClienteNUMCLI: TIntegerField
      FieldName = 'NUMCLI'
    end
    object cdsCadClienteBAIRROCLI: TStringField
      FieldName = 'BAIRROCLI'
      Size = 50
    end
    object cdsCadClienteCOMPLEMENTOCLI: TStringField
      FieldName = 'COMPLEMENTOCLI'
      Size = 60
    end
    object cdsCadClienteCODCIDADE: TIntegerField
      FieldName = 'CODCIDADE'
    end
    object cdsCadClienteTELEFONE1: TStringField
      FieldName = 'TELEFONE1'
    end
    object cdsCadClienteTELEFONE2: TStringField
      FieldName = 'TELEFONE2'
    end
    object cdsCadClienteCELULAR: TStringField
      FieldName = 'CELULAR'
    end
    object cdsCadClienteCEPCLI: TStringField
      FieldName = 'CEPCLI'
      Size = 8
    end
    object cdsCadClienteEMAIL: TStringField
      FieldName = 'EMAIL'
      Size = 100
    end
    object cdsCadClienteDATACADASTRO: TSQLTimeStampField
      FieldName = 'DATACADASTRO'
    end
    object cdsCadClienteDATAATUALIZACAO: TSQLTimeStampField
      FieldName = 'DATAATUALIZACAO'
    end
  end
end