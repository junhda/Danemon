package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PokemonImpl implements Pokemon {
  private String name;
  private TypeSet type;
  private Status status;
  private StatsSet stats;
  private String imageURL;
  private ArrayList<Skill> skills;

  /**
   * Constructor for the PokemonImpl class with dedicated parameters
   * for each property
   * @param name String: name for the Pokemon object
   * @param type TypeSet: type for the Pokemon object
   * @param stats StatsSet: stats for the Pokemon object
   * @param imageURL String: absolute URL to PNG image for the Pokemon object
   * @param skills ArrayList<Skill>: skills for the Pokemon object to attack with
   */
  public PokemonImpl(String name, TypeSet type, StatsSet stats,
      String imageURL, ArrayList<Skill> skills) {
    this.name = name;
    this.type = type;
    this.status = Status.HOLD;
    this.stats = stats;
    this.imageURL = imageURL;
    this.skills = new ArrayList<>();
    for(Skill s : skills) {
      this.skills.add(s);
    }
  }

  /**
   * Constructor for the PokemonImpl class.
   * Randomly assigns Skills based on the type parameter, and StatsSet based
   * on the indexSccale parameter
   * @param name String: name for the Pokemon object
   * @param type TypeSet: type for the Pokemon object
   * @param imageURL String: absolute URL to PNG image for the Pokemon object
   * @param indexScale int: scalar value to act as upper bound for StatsSet
   * @throws IllegalArgumentException when indexScale < 1 or indexScale > 3
   */
  public PokemonImpl(String name, TypeSet type, String imageURL, int indexScale) throws
      IllegalArgumentException {
    if(indexScale < 1 || indexScale > 3) {
      throw new IllegalArgumentException("Expects index scale value between 1 - 3");
    }
    this.name = name;
    this.type = type;
    this.status = Status.HOLD;
    this.stats = new StatsSet(indexScale);
    this.imageURL = imageURL;

    //create a random list of distinct skills for the Pokemon based on the type
    this.skills = new ArrayList<>();
    SkillMap sMap = new SkillMap();
    Random rand = new Random();
    HashMap<Integer, Skill> normalSkills = sMap.getSkillMap().get(Type.NORMAL);
    HashMap<Integer, Skill> typeSkills = sMap.getSkillMap().get(this.type.getType());
    int normalSkillsCount = normalSkills.size();
    int typeSkillsCount = typeSkills.size();
    int skillCount = 0;
    Skill addSkill;
    // adds 4 unique skills to the skills list
    while(skillCount < 4) {
      // choose skill randomly between Normal and same type
      // skillmap has a 1 based index
      if(rand.nextInt(2) == 0) {
        addSkill = normalSkills.get(rand.nextInt(normalSkillsCount) + 1);
      } else {
        addSkill = typeSkills.get(rand.nextInt(typeSkillsCount) + 1);
      }

      // add skill to skill list
      if(!this.skills.contains(addSkill)) {
        this.skills.add(addSkill);
        skillCount++;
      }
    }
  }

  /**
   * Method getName() returns the name property of the Pokemon object
   * @return String: Pokemon name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Method getTypeSet() returns the TypeSet object property of the
   * Pokemon object
   * @return TypeSet: Pokemon TypeSet
   */
  @Override
  public TypeSet getTypeSet() {
    return this.type;
  }

  /**
   * Method getStatsSet() returns the StatsSet object property of the
   * Pokemon object
   * @return StatsSet: Pokemon StatsSet
   */
  @Override
  public StatsSet getStatsSet() {
    return this.stats;
  }

  /**
   * Method getStatus() returns the Status property of the Pokemon object
   * @return Status: Pokemon Status
   */
  @Override
  public Status getStatus() {
    return this.status;
  }

  /**
   * Method getSkillSet() returns an ArrayList filled with the Skills
   * that the Pokemon object has
   * @return ArrayList<Skill>: list of Skill objects the Pokemon has
   */
  @Override
  public ArrayList<Skill> getSkillSet() {
    ArrayList<Skill> result = new ArrayList<>();
    for(Skill skill : this.skills) {
      result.add(skill);
    }
    return result;
  }

  /**
   * Method getSkill() returns the Skill owned by the Pokemon with the matching
   * parameter skill name. If the Pokemon does not know that skill, return null
   * @param skill String: name of the skill to search for
   * @return Skill: skill with matching name as the input. Returns null if not found
   */
  @Override
  public Skill getSkill(String skill) {
    for(Skill sk : this.skills) {
      if(sk.getName() == skill) {
        return sk;
      }
    }
    return null;
  }

  /**
   * Method getImageURL() returns the imageURL property of the Pokemon object
   * @return String: Pokemon Image URL
   */
  @Override
  public String getImageURL() {
    return this.imageURL;
  }

  /**
   * Method setStatus() udpdates the Status property of the Pokemon object
   * to the parameter input value
   * @param s Status: status object for the Pokemon
   */
  @Override
  public void setStatus(Status s) {
    this.status = s;
  }

  /**
   * Method damageCalc() calculates and returns an integer value for the damage that
   * this Pokemon would inflict on an enemy Pokemon using a given attack.
   * Damage considers the user attack, enemy defense, and type matching between the attack
   * Skill and the enemy Pokemon
   * @param attack Skill: attack to use against the enemy Pokemon
   * @param enemy Pokemon: Pokemon getting attacked by this Pokemon
   * @return Int: damage value this Pokemon inflicts to enemy Pokemon with the attack Skill
   * @throws IllegalStateException when the input attack Skill is not in this.skills list
   * @throws IllegalArgumentException when this or enemy Pokemon have status Status.FAINTED
   */
  public int damageCalc(Skill attack, Pokemon enemy) throws IllegalStateException,
      IllegalArgumentException {
    if(!this.skills.contains(attack)) {
      throw new IllegalArgumentException("The Pokemon can only use a Skill it knows!");
    }
    if(this.status != Status.BATTLING || enemy.getStatus() != Status.BATTLING) {
      throw new IllegalStateException("Attacks can only be used between 2 fighting Pokemon");
    }

    int userAttack = this.getStatsSet().getCurrentAttack();
    int enemyDefense = enemy.getStatsSet().getCurrentDefense();
    double typeCoefficient = 1.0;
    if(attack.getType().getWeakness().contains(enemy.getTypeSet().getType())) {
      typeCoefficient = 0.7;
    }
    if(attack.getType().getStrength().contains(enemy.getTypeSet().getType())) {
      typeCoefficient = 1.3;
    }

    return (int)(typeCoefficient * ((double)attack.getPower() *
        ((double)userAttack / (double)enemyDefense)));
  }

  /**
   * Method statChange() applies stat changes to this Pokemon's currentStats.
   * Attack, defense, and speed stats may be affected.
   * @param attackChange double: percent change to this Pokemon's attack stat
   * @param defenseChange double: percent change to this Pokemon's defense stat
   * @param speedChange double: percent change to this Pokemon's speed stat
   * @return ArrayList<String>: list of String values that represent the stat changes that happened
   *    when running statChange()
   * @throws IllegalStateException when this Pokemon is not Battling
   */
  @Override
  public ArrayList<String> statChange(double attackChange, double defenseChange,
      double speedChange) throws IllegalStateException {
    if(this.status != Status.BATTLING) {
      throw new IllegalStateException("Only the Battling Pokemon can be buffed / debuffed.");
    }
    ArrayList<String> output = new ArrayList<>();
    //apply attack change
    if(attackChange != 0.0) {
      this.getStatsSet().setCurrentAttack((int)(this.getStatsSet().getCurrentAttack() *
          (1 + attackChange)));
      if(attackChange < 0.0) {
        output.add(this.name + "'s attack fell!");
      } else {
        output.add(this.name + "'s attack rose!");
      }
    }
    //apply defense change
    if(defenseChange != 0.0) {
      this.getStatsSet().setCurrentDefense((int)(this.getStatsSet().getCurrentDefense() *
          (1 + defenseChange)));
      if(defenseChange < 0.0) {
        output.add(this.name + "'s defense fell!");
      } else {
        output.add(this.name + "'s defense rose!");
      }
    }
    //apply speed change
    if(speedChange != 0.0) {
      this.getStatsSet().setCurrentSpeed((int)(this.getStatsSet().getCurrentSpeed() *
          (1 + speedChange)));
      if(speedChange < 0.0) {
        output.add(this.name + "'s speed fell!");
      } else {
        output.add(this.name + "'s speed rose!");
      }
    }
    //return stat change strings
    return output;
  }

  /**
   * Method attack() uses an attack Skill to inflict damage and apply stat buffs / debuffs
   * to this and the enemy Pokemon
   * @param attack Skill: attack Skill this Pokemon uses to attack
   * @param enemy Pokemon: enemy Pokemon struck by the attack Skill
   * @return ArrayList<String>: list of strings representing the actions that occur as a result
   *  of the attack. Potential items include: attack used, enemy pokemon has fainted,
   *  the user has been buffed / debuffed, or the enemy has been buffed / debuffed
   * @throws IllegalStateException when this or the enemy Pokemon are not Battling
   * @throws IllegalArgumentException when the input attack Skill is not in this.skills list
   */
  @Override
  public ArrayList<String> attack(Skill attack, Pokemon enemy) throws IllegalStateException,
      IllegalArgumentException {
    if(this.status != Status.BATTLING || enemy.getStatus() != Status.BATTLING) {
      throw new IllegalStateException("Attacks can only be used between 2 fighting Pokemon");
    }
    if(!this.skills.contains(attack)) {
      throw new IllegalArgumentException("The Pokemon can only use a Skill it knows!");
    }

    ArrayList<String> output = new ArrayList<>();
    //add string of Skill used by this Pokemon
    output.add(this.name + " used " + attack.getName());

    int result;
    //calc damage
    int damage = this.damageCalc(attack, enemy);

    //apply damage
    ArrayList<String> enemyDamage = enemy.takeDamage(damage);

    //add enemy damage strings to output list
    output.addAll(enemyDamage);

    //apply buffs / debuffs
    ArrayList<String> userStatChange = this.statChange(attack.getUserAttackChange(),
        attack.getUserDefenseChange(), attack.getUserSpeedChange());

    //add user stat change strings to output list
    output.addAll(userStatChange);

    if(enemy.getStatus() != Status.FAINTED) {
      ArrayList<String> enemyStatChange = enemy.statChange(attack.getEnemyAttackChange(),
          attack.getEnemyDefenseChange(), attack.getEnemySpeedChange());

      //add enemy stat change strings to output list
      output.addAll(enemyStatChange);
    }

    //return action result strings
    return output;
  }

  /**
   * Method takeDamage() applies damage to this Pokemon. If the currentHealth of this Pokemon
   * goes down to 0, then the Pokemon's status changes to fainted
   * @param damage Int: amount of damage to do to this Pokemon
   * @return ArrayList<String>: list of Strings that represent actions that have occurred
   * @throws IllegalArgumentException when damage value is negative
   * @throws IllegalStateException when the Pokemon is not actively battling
   */
  @Override
  public ArrayList<String> takeDamage(int damage) throws IllegalArgumentException,
      IllegalStateException {
    if(damage < 0) {
      throw new IllegalArgumentException("Damage value must be positive.");
    }
    if(this.status != Status.BATTLING) {
      throw new IllegalStateException("Only a battling Pokemon can take damage.");
    }

    ArrayList<String> output = new ArrayList<>();
    this.stats.setCurrentHealth(this.stats.getCurrentHealth() - damage);
    if(this.stats.getCurrentHealth() <= 0) {
      this.stats.setCurrentHealth(0);
      this.setStatus(Status.FAINTED);
      output.add(this.name + " fainted.");
    }

    return output;
  }
}
