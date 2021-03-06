package mezz.jei.api.registration;

import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import net.minecraftforge.fluids.FluidStack;

/**
 * Tell JEI how to interpret NBT tags and capabilities when comparing and looking up items and fluids.
 *
 * If your item or fluid has subtypes that depend on NBT or capabilities, use this so JEI can tell those subtypes apart.
 */
public interface ISubtypeRegistration {
	/**
	 * Add an interpreter to compare item subtypes.
	 * This interpreter should account for nbt and anything else that's relevant to differentiating the item's subtypes.
	 *
	 * @param item        the item that has subtypes.
	 * @param interpreter the interpreter for the item.
	 * @deprecated since JEI 7.6.2, use {@link #registerSubtypeInterpreter(Item, IIngredientSubtypeInterpreter)}
	 */
	@Deprecated
	void registerSubtypeInterpreter(Item item, ISubtypeInterpreter interpreter);

	/**
	 * Add an interpreter to compare item subtypes.
	 * This interpreter should account for nbt and anything else that's relevant to differentiating the item's subtypes.
	 *
	 * @param item        the item that has subtypes.
	 * @param interpreter the interpreter for the item.
	 * @since JEI 7.6.2
	 */
	void registerSubtypeInterpreter(Item item, IIngredientSubtypeInterpreter<ItemStack> interpreter);

	/**
	 * Add an interpreter to compare fluid subtypes.
	 * This interpreter should account for nbt and anything else that's relevant to differentiating the fluid's subtypes.
	 *
	 * @param fluid       the fluid that has subtypes.
	 * @param interpreter the interpreter for the fluid.
	 */
	void registerSubtypeInterpreter(Fluid fluid, IIngredientSubtypeInterpreter<FluidStack> interpreter);

	/**
	 * Tells JEI to treat all NBT as relevant to these items' subtypes.
	 */
	void useNbtForSubtypes(Item... items);

	/**
	 * Tells JEI to treat all NBT as relevant to these fluids' subtypes.
	 */
	void useNbtForSubtypes(Fluid... fluids);

	/**
	 * Returns whether an {@link IIngredientSubtypeInterpreter} has been registered for this item.
	 */
	boolean hasSubtypeInterpreter(ItemStack itemStack);

	/**
	 * Returns whether an {@link IIngredientSubtypeInterpreter} has been registered for this fluid.
	 */
	boolean hasSubtypeInterpreter(FluidStack fluidStack);
}
