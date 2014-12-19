create index IX_4BBD9147 on TokenAuth_TokenACLProfile (companyId, name);
create index IX_F462B05F on TokenAuth_TokenACLProfile (name);

create index IX_C1847898 on TokenAuth_TokenClient (clientKey);
create index IX_AEAC8F7C on TokenAuth_TokenClient (companyId);
create index IX_356AFFEB on TokenAuth_TokenClient (name);
create index IX_2C485020 on TokenAuth_TokenClient (uuid_, companyId);

create index IX_8D72665B on TokenAuth_TokenSession (clientId);
create index IX_E2049A7 on TokenAuth_TokenSession (companyId);
create index IX_22E1DF95 on TokenAuth_TokenSession (uuid_, companyId);