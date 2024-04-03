# Clean up

```
aws sesv2 delete-contact-list --contact-list-name weekly-coupons-newsletter
```

# Java

```
mvn exec:java -Dexec.mainClass=com.example.sesv2.ContactList
```

# Kotlin

```
gradle run
```

# Python

```
python contactlist.py
```

# Rust

```
cargo run
```
