-- Table: alert_requisition_approved

 DROP TABLE IF EXISTS alert_requisition_approved;

CREATE TABLE alert_requisition_approved
(
  id serial NOT NULL,
  alertsummaryid integer,
  rnrid integer,
  rnrtype character varying(50),
  facilityid integer,
  facilityname character varying(50),
  CONSTRAINT alert_requisition_approved_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE alert_requisition_approved
  OWNER TO postgres;
