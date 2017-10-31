# EasyPage
Simple way Learning JSF + EJB + JPA


#JBOSS CONFIGURATION
<datasource jta="true" jndi-name="java:jboss/datasources/easy_page_pu" pool-name="easy_page_pu" enabled="true">
	<connection-url>jdbc:edb://localhost:5432/easy_page</connection-url>
    <driver>com.edb</driver>
    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
		<pool>
			<min-pool-size>100</min-pool-size>
            <max-pool-size>200</max-pool-size>
		</pool>
			<security>
				<user-name>postgres</user-name>
                <password>pgadmin</password>
		</security>
		<validation>
			<check-valid-connection-sql>select 1</check-valid-connection-sql>
		</validation>
		<statement>
            <prepared-statement-cache-size>100</prepared-statement-cache-size>
            <share-prepared-statements>true</share-prepared-statements>
        </statement>
</datasource>-->

#Database has been include within the project