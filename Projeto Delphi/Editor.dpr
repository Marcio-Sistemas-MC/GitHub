program Editor;

uses
  Forms,
  u_Editor in 'u_Editor.pas' {f_Editor};

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(Tf_Editor, f_Editor);
  Application.Run;
end.
