package lance5057.tDefense.core.library;

import lance5057.tDefense.core.materials.stats.ArmorMaterialStats;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.Tags;

public class ArmorNBT {

  public int durability;
  public int armorRating;
  public int armorToughness;
  public int modifiers; // free modifiers
  private final NBTTagCompound parent;

  public ArmorNBT() {
    durability = 0;
    armorRating = 0;
    armorToughness = 0;
    modifiers = 5;
    parent = new NBTTagCompound();
  }

  public ArmorNBT(NBTTagCompound tag) {
    read(tag);
    parent = tag;
  }

  /** Initialize the stats with the heads. CALL THIS FIRST */
  public ArmorNBT head(ArmorMaterialStats... heads) {
    durability = 0;
    armorRating = 0;
    armorToughness = 0;

    // average all stats
    for(ArmorMaterialStats head : heads) {
      if(head != null) {
        durability += head.durability;
        armorRating += head.rating;
        armorToughness += head.toughness;
      }
    }

    durability = Math.max(1, durability / heads.length);
    armorRating /= (float) heads.length;
    armorToughness /= (float) heads.length;

    return this;
  }

  /** Add stats from the accessoires. Call this second! */
  public ArmorNBT extra(ExtraMaterialStats... extras) {
    int dur = 0;
    for(ExtraMaterialStats extra : extras) {
      if(extra != null) {
        dur += extra.extraDurability;
      }
    }
    this.durability += Math.round((float) dur / (float) extras.length);

    return this;
  }

  /** Calculate in handles. call this last! */
  public ArmorNBT handle(HandleMaterialStats... handles) {
	    // (Average Head Durability + Average Extra Durability) * Average Handle Modifier + Average Handle Durability

	    int dur = 0;
	    float modifier = 0f;
	    for(HandleMaterialStats handle : handles) {
	      if(handle != null) {
	        dur += handle.durability;
	        modifier += handle.modifier;
	      }
	    }

	    modifier /= (float) handles.length;
	    this.durability = Math.round((float) this.durability * modifier);

	    // add in handle durability change
	    this.durability += Math.round((float) dur / (float) handles.length);

	    this.durability = Math.max(1, this.durability);

	    return this;
	  }

  public void read(NBTTagCompound tag) {
    durability = tag.getInteger(Tags.DURABILITY);
    armorRating = tag.getInteger(ArmorTags.ArmorRating);
    armorToughness = tag.getInteger(ArmorTags.ArmorToughness);
    modifiers = tag.getInteger(Tags.FREE_MODIFIERS);
    
    
  }

  public void write(NBTTagCompound tag) {
    tag.setInteger(Tags.DURABILITY, durability);
    tag.setInteger(ArmorTags.ArmorRating, armorRating);
    tag.setInteger(ArmorTags.ArmorToughness, armorToughness);
    tag.setInteger(Tags.FREE_MODIFIERS, modifiers);
  }

  public NBTTagCompound get() {
    NBTTagCompound tag = parent.copy();
    write(tag);

    return tag;
  }

  // AUtogenerated equals and hashcode
  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(o == null || getClass() != o.getClass()) {
      return false;
    }

    ArmorNBT toolNBT = (ArmorNBT) o;

    if(durability != toolNBT.durability) {
      return false;
    }
    if(Float.compare(toolNBT.armorRating, armorRating) != 0) {
      return false;
    }
    if(Float.compare(toolNBT.armorToughness, armorToughness) != 0) {
      return false;
    }
    return modifiers == toolNBT.modifiers;

  }

  @Override
  public int hashCode() {
    int result = durability;
    result = 31 * result + (armorRating != +0.0f ? Float.floatToIntBits(armorRating) : 0);
    result = 31 * result + (armorToughness != +0.0f ? Float.floatToIntBits(armorToughness) : 0);
    result = 31 * result + modifiers;
    return result;
  }
}