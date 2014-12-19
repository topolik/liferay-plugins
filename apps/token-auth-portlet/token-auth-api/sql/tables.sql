create table TokenAuth_TokenACLProfile (
	aclProfileId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	acl VARCHAR(75) null,
	parentProfileId LONG,
	effectiveACL VARCHAR(75) null,
	system BOOLEAN
);

create table TokenAuth_TokenClient (
	clientId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	clientKey VARCHAR(75) null,
	clientSecrets VARCHAR(75) null,
	revoked BOOLEAN,
	aclProfiles VARCHAR(75) null,
	tokenVerifierId VARCHAR(75) null,
	callbackURI VARCHAR(75) null,
	websiteURL VARCHAR(75) null,
	additionalInfo VARCHAR(75) null
);

create table TokenAuth_TokenSession (
	sessionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	clientId LONG,
	token VARCHAR(75) null,
	remoteInfo VARCHAR(75) null,
	lastUsedDate DATE null,
	additionalInfo VARCHAR(75) null,
	expiryDate DATE null
);