package Main;
import Attack.*;
import defense.*;
import Fly.*;
import Sound.*;
public class Duck 
{
    private AttackBehaviour attackBehaviour;
    private DefenseBehaviour defenseBehaviour;
    private FlyBehaviour flyBehaviour;
    private SoundBehaviour soundBehaviour;
    public Duck(AttackBehaviour a , DefenseBehaviour b , FlyBehaviour c , SoundBehaviour d)
    {
    	this.attackBehaviour = a;
    	this.defenseBehaviour = b;
    	this.flyBehaviour = c;
    	this.soundBehaviour = d;
    }
    public void attack()
    {
    	attackBehaviour.Attack();
    }
    public void defense()
    {
    	defenseBehaviour.defense();
    }
    public void fly()
    {
    	flyBehaviour.Fly();
    }
    public void sound()
    {
    	soundBehaviour.Sound();
    }
}
