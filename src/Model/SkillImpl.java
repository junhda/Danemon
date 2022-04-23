package Model;

public class SkillImpl implements Skill {
  private TypeSet type;
  private String name;
  private int power;
  private double userAttackChange;
  private double userDefenseChange;
  private double userSpeedChange;
  private double enemyAttackChange;
  private double enemyDefenseChange;
  private double enemySpeedChange;


  public SkillImpl(TypeSet type, String name, int power,
      double userAttackChange, double userDefenseChange, double userSpeedChange,
      double enemyAttackChange, double enemyDefenseChange, double enemySpeedChange) {
    this.type = type;
    this.name = name;
    this.power = power;
    this.userAttackChange = userAttackChange;
    this.userDefenseChange = userDefenseChange;
    this.userSpeedChange = userSpeedChange;
    this.enemyAttackChange = enemyAttackChange;
    this.enemyDefenseChange = enemyDefenseChange;
    this.enemySpeedChange = enemySpeedChange;
  }

  /**
   * Method getType() returns the TypeSet associated with the Pokemon Skill
   * @return TypeSet: Type of the Skill
   */
  @Override
  public TypeSet getType() {
    return this.type;
  }

  /**
   * Method getName() returns the name property of the Pokemon Skill
   * @return String: name of the Skill
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Method getPower() returns the power property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public int getPower() {
    return this.power;
  }

  /**
   * Method getUserAttackChange() returns the userAttackChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getUserAttackChange() {
    return this.userAttackChange;
  }

  /**
   * Method getUserDefenseChange() returns the UserDefenseChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getUserDefenseChange() {
    return this.userDefenseChange;
  }

  /**
   * Method getUserSpeedChange() returns the UserSpeedChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getUserSpeedChange() {
    return this.userSpeedChange;
  }

  /**
   * Method getEnemyAttackChange() returns the EnemyAttackChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getEnemyAttackChange() {
    return this.enemyAttackChange;
  }

  /**
   * Method getEnemyDefenseChange() returns the EnemyDefenseChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getEnemyDefenseChange() {
    return this.enemyDefenseChange;
  }

  /**
   * Method getEnemySpeedChange() returns the EnemySpeedChange property of the Pokemon Skill
   * @return Int: power of the Skill
   */
  @Override
  public double getEnemySpeedChange() {
    return this.enemySpeedChange;
  }

//  @Override
//  public int damageCalc(Pokemon user, Pokemon enemy) {
//    int userAttack = user.getStatsSet().getCurrentAttack();
//    int enemyDefense = enemy.getStatsSet().getCurrentDefense();
//    double typeCoefficient = 1.0;
//    if(this.type.getWeakness().contains(enemy.getTypeSet().getType())) {
//      typeCoefficient = 0.7;
//    }
//    if(this.type.getStrength().contains(enemy.getTypeSet().getType())) {
//      typeCoefficient = 1.3;
//    }
//
//    return (int)(typeCoefficient * (this.power *
//        (1 + (userAttack - enemyDefense) / 50)));
//  }
//
//  @Override
//  public void affectStats(Pokemon user, Pokemon enemy) {
//    return;
//  }
}
