public class interfaceClass 
{
    interface characterInterface
    {
        String printClassName();
        double printHealth();
        int printMana();
        int printDamage();
        double healCharacter(double amount);
        double damageCharacter(double amount);
    }

    abstract class character implements characterInterface
    {
        protected String className;
        protected double health;
        protected double currentHealth;
        protected int mana;
        protected int damage;

        protected character(String className, double health, int mana, int damage)
        {
            this.className = className;
            this.health = health;
            this.mana = mana;
            this.damage = damage;
            this.currentHealth = health;
        }
        @Override
        public double healCharacter(double amount)
        {
            if(currentHealth < health || currentHealth > 0)
            {
                currentHealth += amount;
            }
            else if(currentHealth < 0)
            {
                return 0;
            }

            return currentHealth;
        }

        @Override
        public double damageCharacter(double amount)
        {
            if(currentHealth < health || currentHealth > 0)
            {
                currentHealth -= amount;
            }
            else if(currentHealth < 0)
            {
                return 0;
            }

            return currentHealth;
        }
    }

    private class playerCharacter extends character
    {

        protected playerCharacter(String className, double health, int mana, int damage)
        {
            super(className, health, mana, damage);
        }

        @Override
        public int printDamage()
        {
            System.out.println("Damage: " + super.damage);
            return super.damage;
        }

        @Override
        public String printClassName()
        {
            System.out.println("Class: " + super.className);
            return super.className;
        }

        @Override
        public int printMana()
        {
            System.out.println("Mana: " + super.mana);
            return super.mana;
        }

        @Override
        public double printHealth()
        {
            System.out.println("Health: " +  super.currentHealth +"/"+ super.health);
            return super.health;
        }
    }

    public static void main(String[] args)
    {
        interfaceClass test = new interfaceClass();
        String className = "Archer";
        double health = 500;
        int mana = 300;
        int damage = 50;
        character playerCharacter = test.new playerCharacter(className, health, mana, damage);
        playerCharacter.printClassName();
        playerCharacter.printDamage();
        playerCharacter.damageCharacter(damage);
        playerCharacter.printHealth();
        playerCharacter.printMana();
    }
}
