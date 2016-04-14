/*
 * Copyright (c) 2016.
 */

package gof.creation.Builder;

/**
 * Created by Valko Serhii on 14-Apr-16.
 */
public class Contact
{
    private final String name;

    private final String surname;

    private final String mail;

    private final String phone;

    private final String address;

    private Contact(final ContactBuilder contactBuilder)
    {
        this.name = contactBuilder.getName();
        this.surname = contactBuilder.getSurname();
        this.mail = contactBuilder.getMail();
        this.phone = contactBuilder.getPhone();
        this.address = contactBuilder.getAddress();
    }

    @Override
    public String toString()
    {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * Created by Valko Serhii on 08-Apr-16.
     */
    public static final class ContactBuilder
    {
        private String name;

        private String surname;

        private String mail;

        private String phone;

        private String address;

        public ContactBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public ContactBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public ContactBuilder mail(String mail)
        {
            this.mail = mail;
            return this;
        }

        public ContactBuilder phone(String phone)
        {
            this.phone = phone;
            return this;
        }

        public ContactBuilder address(String address)
        {
            this.address = address;
            return this;
        }

        private String getName()
        {
            return name;
        }

        private String getSurname()
        {
            return surname;
        }

        private String getMail()
        {
            return mail;
        }

        private String getPhone()
        {
            return phone;
        }

        private String getAddress()
        {
            return address;
        }

        public Contact build()
        {
            assert this.name != null;
            assert this.surname != null;
            assert this.mail != null;
            assert this.phone != null;
            assert this.address != null;

            return new Contact(this);
        }
    }
}
