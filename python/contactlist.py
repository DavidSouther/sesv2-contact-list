import boto3

CONTACT_LIST_NAME = "weekly-coupons-newsletter"
# SesV2Client sesClient = SesV2Client.builder().build();
ses_client = boto3.client("sesv2")
# sesClient.createContactList(CreateContactListRequest.builder().contactListName(CONTACT_LIST_NAME).build());
ses_client.create_contact_list(ContactListName=CONTACT_LIST_NAME)
print("Created contact list")
list = ses_client.list_contacts(ContactListName=CONTACT_LIST_NAME)
print(f"Listed contacts: {list['Contacts']}")
ses_client.delete_contact_list(ContactListName=CONTACT_LIST_NAME)
print("Created contact list")
