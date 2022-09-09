package com.cigna.ctc.apprunner;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.model.Region;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.cigna.ctc.apprunner")
public class DynamoDBConfiguration {
    @Value("${amazon.dynamodb.endpoint}")
    private String awsEndpoint;

    @Value("${amazon.aws.region}")
    private String awsRegion;

    @Value("${amazon.aws.accesskey}")
    private String awsAccessKey;
    
    @Value("${amazon.aws.secretkey}")
    private String awsSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        //software.amazon.awssdk.regions.Region region = software.amazon.awssdk.regions.Region.of(awsRegion);
        //return DynamoDbClient.builder().region(region).build();
        EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(awsEndpoint, awsRegion);
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(endpointConfiguration).build();
    }
}
