object frmPrincipal: TfrmPrincipal
  Left = 186
  Top = 254
  Width = 928
  Height = 480
  Align = alClient
  Caption = 'Sistema Comercial'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  Menu = MainMenu1
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object stbDatahora: TStatusBar
    Left = 0
    Top = 402
    Width = 912
    Height = 19
    Panels = <
      item
        Alignment = taCenter
        Width = 120
      end
      item
        Alignment = taCenter
        Width = 120
      end
      item
        Alignment = taCenter
        Width = 120
      end>
  end
  object MainMenu1: TMainMenu
    Left = 96
    Top = 16
    object Cadastro1: TMenuItem
      Caption = '&Cadastro'
      object Cliente1: TMenuItem
        Caption = 'C&liente'
      end
      object Fornecedor1: TMenuItem
        Caption = '&Fornecedor'
      end
      object N1: TMenuItem
        Caption = '-'
      end
      object Produto1: TMenuItem
        Caption = 'Fo&rma de Pagamento'
      end
      object CondiesdePagamento1: TMenuItem
        Caption = 'Co&ndi'#231#245'es de Pagamento'
      end
      object N2: TMenuItem
        Caption = '-'
      end
      object Produto2: TMenuItem
        Caption = '&Produto'
      end
      object N3: TMenuItem
        Caption = '-'
      end
      object Usurios1: TMenuItem
        Caption = '&Usu'#225'rios'
      end
    end
    object Vendas1: TMenuItem
      Caption = '&Vendas'
      object Vender1: TMenuItem
        Caption = 'Vender'
      end
    end
    object Compras1: TMenuItem
      Caption = 'Compras'
      object Pedido1: TMenuItem
        Caption = 'Pedido'
      end
    end
    object Relatrios1: TMenuItem
      Caption = '&Relat'#243'rios'
    end
    object Sair1: TMenuItem
      Caption = '&Sair'
    end
  end
  object Timer1: TTimer
    OnTimer = Timer1Timer
    Left = 168
    Top = 32
  end
end