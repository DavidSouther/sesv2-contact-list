use anyhow::Result;
use aws_config::BehaviorVersion;
use aws_sdk_sesv2::Client;

const CONTACT_LIST_NAME: &str = "weekly-coupons-newsletter";

#[tokio::main]
async fn main() -> Result<()> {
    tracing_subscriber::fmt::init();

    let config = aws_config::load_defaults(BehaviorVersion::latest()).await;
    let client = Client::new(&config);

    client
        .create_contact_list()
        .contact_list_name(CONTACT_LIST_NAME)
        .send()
        .await?;
    println!("Created contact list");
    let list = client
        .list_contacts()
        .contact_list_name(CONTACT_LIST_NAME)
        .send()
        .await?;
    println!("Listed contacts: {:?}", list.contacts());
    client
        .delete_contact_list()
        .contact_list_name(CONTACT_LIST_NAME)
        .send()
        .await?;
    println!("Created contact list");

    Ok(())
}
