package br.com.matheus.people.api.contract;

import br.com.matheus.people.api.clients.PatchPersonClient;
import br.com.matheus.people.api.models.Person;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContractPatchPersonTest {

    private PatchPersonClient patchPersonClient = new PatchPersonClient();

    @Test
    public void validateContractPatchPerson() {
        Person person = Person.builder().id(1).build();
        String requestBody = "{\"name\": \"ContractTest\"}";
        patchPersonClient.patchPerson(person, requestBody).body(matchesJsonSchema(
                new File("src/test/resources/json_schema/person/person_schema.json")));
    }
}
