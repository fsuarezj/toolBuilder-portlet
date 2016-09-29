create table lrc_tb_CS_Step (
	compositeStepDBEId LONG not null,
	stepDBEId LONG not null,
	primary key (compositeStepDBEId, stepDBEId)
);

create table lrc_tb_CompositeStepDBE (
	compositeStepDBEId LONG not null primary key,
	currentStep INTEGER,
	compositeStepDefDBEId LONG
);

create table lrc_tb_CompositeStepDefDBE (
	compositeStepDefDBEId LONG not null primary key,
	stepsNumber INTEGER,
	sequential BOOLEAN,
	depth INTEGER
);

create table lrc_tb_InstalledStep (
	stepType VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	namespace VARCHAR(75) null,
	className VARCHAR(75) null,
	stepDescription VARCHAR(75) null
);

create table lrc_tb_StepDBE (
	stepDBEId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stepType VARCHAR(75) null,
	stepTypeId LONG
);

create table lrc_tb_StepDefDBE (
	stepDefDBEId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stepType VARCHAR(75) null,
	stepTypeId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table lrc_tb_StepDefsCompositeStepDefDBE (
	compositeStepDefDBEId LONG not null,
	stepDefDBEId LONG not null,
	stepIndex INTEGER,
	primary key (compositeStepDefDBEId, stepDefDBEId)
);

create table lrc_tb_ToolDefDBE (
	toolDefDBEId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	toolName VARCHAR(75) null,
	compositeStepDefDBEId LONG,
	toolDescription VARCHAR(75) null
);

create table lrc_tb_ToolInstanceDBE (
	toolInstanceDBEId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	toolDefDBEId LONG,
	compositeStepDBEId LONG,
	toolTitle VARCHAR(75) null
);