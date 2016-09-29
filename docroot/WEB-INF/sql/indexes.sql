create index IX_8B692BD5 on lrc_tb_CS_Step (compositeStepDBEId);
create index IX_5B8A7374 on lrc_tb_CS_Step (stepDBEId);

create index IX_1840210C on lrc_tb_CompositeStepDBE (compositeStepDBEId);

create index IX_3E468774 on lrc_tb_CompositeStepDefDBE (compositeStepDefDBEId);

create unique index IX_DC6DB0F7 on lrc_tb_InstalledStep (stepType);

create index IX_92ADE7B4 on lrc_tb_StepDBE (stepDBEId);

create index IX_E82A48C0 on lrc_tb_StepDefDBE (stepDefDBEId);

create index IX_911FB76E on lrc_tb_StepDefsCompositeStepDefDBE (CompositeStepDefDBEId);
create index IX_D752DF8E on lrc_tb_StepDefsCompositeStepDefDBE (compositeStepDefDBEId);

create index IX_37079E58 on lrc_tb_ToolDefDBE (toolDefDBEId);
create unique index IX_A0E2BFC6 on lrc_tb_ToolDefDBE (toolName);

create index IX_56F9B982 on lrc_tb_ToolInstanceDBE (groupId, toolDefDBEId);
create index IX_5D83B5DA on lrc_tb_ToolInstanceDBE (toolDefDBEId);
create index IX_7003C694 on lrc_tb_ToolInstanceDBE (toolInstanceDBEId);

create index IX_E934CDBB on lrc_tb__CSDef_StepDef (compositeStepDefDBEId);
create index IX_95F33082 on lrc_tb__CSDef_StepDef (stepDefDBEId);

create index IX_15130154 on lrc_tb__CS_Step (compositeStepDBEId);
create index IX_35A315 on lrc_tb__CS_Step (stepDBEId);

create index IX_A8450A6D on lrc_tb__CompositeStepDBE (compositeStepDBEId);

create index IX_52752415 on lrc_tb__CompositeStepDefDBE (compositeStepDefDBEId);

create unique index IX_B1241DF6 on lrc_tb__InstalledStep (stepType);

create index IX_37591755 on lrc_tb__StepDBE (stepDBEId);

create index IX_AA417BA1 on lrc_tb__StepDefDBE (stepDefDBEId);

create index IX_F91ED139 on lrc_tb__ToolDefDBE (toolDefDBEId);
create unique index IX_C7808B27 on lrc_tb__ToolDefDBE (toolName);

create index IX_F969CEA3 on lrc_tb__ToolInstanceDBE (groupId, toolDefDBEId);
create index IX_240E2799 on lrc_tb__ToolInstanceDBE (toolDefDBEId);
create index IX_49459435 on lrc_tb__ToolInstanceDBE (toolInstanceDBEId);