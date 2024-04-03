package com.example.sesv2;

import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.CreateContactListRequest;
import software.amazon.awssdk.services.sesv2.model.DeleteContactListRequest;
import software.amazon.awssdk.services.sesv2.model.ListContactsRequest;

public class ContactList {

  private static final String CONTACT_LIST_NAME = "weekly-coupons-newsletter"; // Replace with your contact list name

  public static void main(String[] args) {
    SesV2Client sesClient = SesV2Client.builder().build();
    sesClient.createContactList(CreateContactListRequest.builder().contactListName(CONTACT_LIST_NAME).build());
    System.out.println("Created contact list");
    var list = sesClient.listContacts(ListContactsRequest.builder().contactListName(CONTACT_LIST_NAME).build());
    System.out.println("Listed contacts: " + list.contacts().size());
    sesClient.deleteContactList(DeleteContactListRequest.builder().contactListName(CONTACT_LIST_NAME).build());
    System.out.println("Created contact list");
  }
}